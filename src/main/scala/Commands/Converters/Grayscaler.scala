package Commands.Converters

import Models.Images.{GrayscaleImage, RgbImage}
import Models.Pixels.GrayscalePixel

class Grayscaler extends Converter[RgbImage, GrayscaleImage] {
  override def convert(source: RgbImage) : GrayscaleImage = {
    var pixelGrid: List[List[GrayscalePixel]] = List()

    for (y <- 0 until source.getHeight) {
      var row: List[GrayscalePixel] = List()
      for (x <- 0 until source.getWidth) {
        val pixelValue = source.getPixel(y, x).getValue

        val red = (pixelValue & 0xff0000) >> 16
        val green = (pixelValue & 0xff00) >> 8
        val blue = pixelValue & 0xff

        val grayscalePixel = GrayscalePixel(255 - ((0.3 * red) + (0.59 * green) + (0.11 * blue)).toInt)

        row = row :+ grayscalePixel
      }
      pixelGrid = pixelGrid :+ row
    }

    GrayscaleImage(pixelGrid)
  }
}
