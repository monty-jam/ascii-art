package Commands.Converters.Symbolers

import Models.{AsciiImage, GrayscaleImage}

class NonLinearSymboler extends Symboler {
  override def convert(source: GrayscaleImage): AsciiImage = {
    var pixelGrid: List[List[Char]] = List()

    for (y <- 0 until source.getHeight) {
      var row: List[Char] = List()
      for (x <- 0 until source.getWidth) {
        val pixel = source.getPixel(y, x)
        if (pixel <= 150)
          row = row :+ '+'
        else if (pixel <= 200)
          row = row :+ '='
        else
          row = row :+ '.'
      }
      pixelGrid = pixelGrid :+ row
    }

    AsciiImage(pixelGrid)
  }
}
