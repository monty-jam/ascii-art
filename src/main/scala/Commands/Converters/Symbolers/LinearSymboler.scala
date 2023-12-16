package Commands.Converters.Symbolers

import Models.Images.{AsciiImage, GrayscaleImage}
import Models.Pixels.AsciiPixel

class LinearSymboler(table: String) extends Symboler {
  override def convert(source: GrayscaleImage): AsciiImage = {
    var pixelGrid: List[List[AsciiPixel]] = List()
    val separation = 255 / table.length + 1

    for (y <- 0 until source.getHeight) {
      var row: List[AsciiPixel] = List()
      for (x <- 0 until source.getWidth) {
        val pixelValue = source.getPixel(y, x).getValue
        val symbol = table((pixelValue / separation).toInt)

        row = row :+ AsciiPixel(symbol)
      }
      pixelGrid = pixelGrid :+ row
    }

    AsciiImage(pixelGrid)
  }
}
