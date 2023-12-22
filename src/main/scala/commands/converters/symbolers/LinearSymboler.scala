package commands.converters.symbolers

import models.images.{AsciiImage, GrayscaleImage}
import models.pixels.AsciiPixel

/**
 * Abstract class for converting grayscale images to ascii images using a linear table
 */
class LinearSymboler(table: String) extends Symboler {
  override def convert(source: GrayscaleImage): AsciiImage = {
    if (table.length < 1)
      throw new Exception("Table must have at least one symbol")

    var pixelGrid: List[List[AsciiPixel]] = List()
    val separation = 255 / table.length + 1

    for (y <- 0 until source.getHeight) {
      var row: List[AsciiPixel] = List()
      for (x <- 0 until source.getWidth) {
        val pixelValue = source.getPixel(y, x).getValue
        val symbol = table(table.length - 1 - (pixelValue / separation))

        row = row :+ AsciiPixel(symbol)
      }
      pixelGrid = pixelGrid :+ row
    }

    AsciiImage(pixelGrid)
  }
}
