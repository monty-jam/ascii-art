package commands.converters.symbolers

import models.images.{AsciiImage, GrayscaleImage}
import models.pixels.AsciiPixel

/**
 * Abstract class for converting grayscale images to ascii images using a non-linear table
 */
class NonLinearSymboler extends Symboler {
  override def convert(source: GrayscaleImage): AsciiImage = {
    var pixelGrid: List[List[AsciiPixel]] = List()

    for (y <- 0 until source.getHeight) {
      var row: List[AsciiPixel] = List()
      for (x <- 0 until source.getWidth) {
        val pixelValue = source.getPixel(y, x).getValue
        if (pixelValue <= 150)
          row = row :+ AsciiPixel('+')
        else if (pixelValue <= 200)
          row = row :+ AsciiPixel('=')
        else
          row = row :+ AsciiPixel('.')
      }
      pixelGrid = pixelGrid :+ row
    }

    AsciiImage(pixelGrid)
  }
}
