package main

import commands.converters.symbolers.{LinearSymboler, NonLinearSymboler, Symboler}
import commands.converters.{Grayscaler, Stringer}
import commands.exporters.{FileOutputExporter, StdOutputExporter, StreamTextExporter}
import commands.filters._
import commands.loaders.fileloaders.{JpgRgbImageLoader, PngRgbImageLoader}
import commands.loaders.{GeneratorRgbImageLoader, Loader}
import models.filepaths.{JpgFilePath, PngFilePath}
import models.images.RgbImage

import java.io.File
import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

class Program {
  private val rgbImageLoaders: ArrayBuffer[Loader[RgbImage]] = ArrayBuffer.empty
  private val grayscaler = new Grayscaler
  private val filters: ArrayBuffer[GrayscaleFilter] = ArrayBuffer()
  private val symbolers: ArrayBuffer[Symboler] = ArrayBuffer().empty
  private val stringer = new Stringer
  private val exporters: ArrayBuffer[StreamTextExporter] = ArrayBuffer()

  @tailrec
  final def parse(args: List[String]): Unit = {
    args match {
      case "--image" :: filePathValue :: tail =>
        if (filePathValue.split('.').last == "jpg")
          rgbImageLoaders += new JpgRgbImageLoader(JpgFilePath(filePathValue))
        else if (filePathValue.split('.').last == "png")
          rgbImageLoaders += new PngRgbImageLoader(PngFilePath(filePathValue))
        else
          throw new Exception("Invalid image file format.")
        parse(tail)
      case "--image-random" :: tail =>
        rgbImageLoaders += new GeneratorRgbImageLoader
        parse(tail)
      case "--brightness" :: value :: tail =>
        filters += new BrightnessGrayscaleFilter(value.toInt)
        parse(tail)
      case "--flip" :: axis :: tail =>
        if (axis == "x")
          filters += new XAxisFlipGrayscaleFilter
        else if (axis == "y")
          filters += new YAxisFlipGrayscaleFilter
        else
          throw new Exception("Invalid axis argument for --flip.")
        parse(tail)
      case "--invert" :: tail =>
        filters += new InverseGrayscaleFilter
        parse(tail)
      case "--table" :: "paulBorkes" :: tail =>
        symbolers += new LinearSymboler(" .:-=+*#%@")
        parse(tail)
      case "--table" :: "nonLinear" :: tail =>
        symbolers += new NonLinearSymboler
        parse(tail)
      case "--custom-table" :: table :: tail =>
        symbolers += new LinearSymboler(table)
        parse(tail)
      case "--output-file" :: filePath :: tail =>
        exporters += new FileOutputExporter(new File(filePath))
        parse(tail)
      case "--output-console" :: tail =>
        exporters += new StdOutputExporter
        parse(tail)
      case Nil =>
      case line =>
        throw new Exception("Invalid input: " + line)
    }
  }

def run(): Unit = {
  if (rgbImageLoaders.length != 1) {
    throw new Exception("Incorrect amount of loaders (should be exactly one).")
  }

  if (symbolers.length > 1)
    throw new Exception("Too many defined conversion tables (should be 0 or 1).")
  else if (symbolers.isEmpty)
    symbolers += new LinearSymboler(" .:-=+*#%@") // default one

  val rgbImage = rgbImageLoaders(0).load()
  var grayscaleImage = grayscaler.convert(rgbImage)
  filters.foreach(filter =>
    grayscaleImage = filter.filter(grayscaleImage)
  )
  val asciiImage = symbolers(0).convert(grayscaleImage)
  val line = stringer.convert(asciiImage)
  exporters.foreach(exporter =>
    exporter.`export`(line)
  )
}

}
