package commands.converters.symbolers

import commands.converters.Converter
import models.images.{AsciiImage, GrayscaleImage}

/**
 * Abstract class for converting grayscale images to ascii images
 */
trait Symboler extends Converter[GrayscaleImage, AsciiImage] {

}
