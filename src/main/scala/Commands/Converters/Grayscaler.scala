package Commands.Converters

import Models.{GrayscaleImage, RgbImage}

class Grayscaler extends Converter[RgbImage, GrayscaleImage] {
  override def convert(source: RgbImage) : GrayscaleImage = {
    var pixelGrid: List[List[Float]] = List()

    for (y <- 0 until source.getHeight) {
      var row: List[Float] = List()
      for (x <- 0 until source.getWidth) {
        val pixel = source.getPixel(y, x)
        val red = (pixel & 0xff0000) >> 16
        val green = (pixel & 0xff00) >> 8
        val blue = pixel & 0xff
        val grayscale = 255 - ((0.3 * red) + (0.59 * green) + (0.11 * blue)).toInt

        row = row :+ grayscale
      }
      pixelGrid = pixelGrid :+ row
    }

    GrayscaleImage(pixelGrid)
  }
}
