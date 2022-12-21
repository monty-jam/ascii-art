package Commands.Converters.Symbolers

import Models.{AsciiImage, GrayscaleImage}

class LinearSymboler(table: String) extends Symboler {
  override def convert(source: GrayscaleImage): AsciiImage = {
    var pixelGrid: List[List[Char]] = List()
    val separation = 255 / table.length + 1

    for (y <- 0 until source.getHeight) {
      var row: List[Char] = List()
      for (x <- 0 until source.getWidth) {
        val pixel = source.getPixel(y, x)
        val symbol = table((pixel / separation).toInt)

        row = row :+ symbol
      }
      pixelGrid = pixelGrid :+ row
    }

    AsciiImage(pixelGrid)
  }
}
