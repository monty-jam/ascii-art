package Main

import Commands.Converters.Symbolers.{LinearSymboler, NonLinearSymboler}
import Commands.Converters.{Grayscaler, Stringer}
import Commands.Exporters.FileOutputExporter
import Commands.Loaders.FileRgbImageLoader
import Models.Images.RgbImage

import java.awt.Image
import java.io.File

object Main extends App {
  private var program = new Program

//  try {
    program.parse(args.toList)
    program.run()
//  } catch {
//    case e:Any => println(e.getMessage)
//  }
}