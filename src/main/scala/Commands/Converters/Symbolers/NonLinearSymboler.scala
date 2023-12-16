package Commands.Converters.Symbolers

import Models.Images.{AsciiImage, GrayscaleImage}
import Models.Pixels.AsciiPixel

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
