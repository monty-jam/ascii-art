package commands.converters.symbolers

import commands.converters.Converter
import models.Images.{AsciiImage, GrayscaleImage}

trait Symboler extends Converter[GrayscaleImage, AsciiImage] {

}
