package Main

import Commands.Converters.Symbolers.{LinearSymboler, NonLinearSymboler, Symboler}
import Commands.Converters.{Grayscaler, Stringer}
import Commands.Exporters.{FileOutputExporter, StdOutputExporter, StreamTextExporter, TextExporter}
import Commands.Filters.{BrightnessFilter, FlipFilter, GrayscaleFilter, InverseFilter}
import Commands.Loaders.{FileRgbImageLoader, GeneratorRgbImageLoader, Loader, RgbImageLoader}
import Models.Images.RgbImage

import java.io.File
import scala.annotation.tailrec
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

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
      case "--image-file" :: filePath :: tail =>
        rgbImageLoaders += new FileRgbImageLoader(filePath)
        parse(tail)
      case "--image-generator" :: tail =>
        rgbImageLoaders += new GeneratorRgbImageLoader
        parse(tail)
      case "--brightness" :: value :: tail =>
        filters += new BrightnessFilter(value.toInt)
        parse(tail)
      case "--flip" :: axis :: tail =>
        filters += new FlipFilter(axis)
        parse(tail)
      case "--invert" :: tail =>
        filters += new InverseFilter
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
      case line :: tail =>
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
