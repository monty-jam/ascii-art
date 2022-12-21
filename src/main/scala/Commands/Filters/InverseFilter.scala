package Commands.Filters

import Models.{AsciiImage, GrayscaleImage}

class InverseFilter extends GrayscaleFilter {

  override def filter(source: GrayscaleImage): GrayscaleImage = {
    for (y <- 0 until source.getHeight) {
      var row: List[Float] = List()
      for (x <- 0 until source.getWidth) {
        val pixel = 255 - source.getPixel(y, x)

        row = row :+ pixel
      }
      pixelGrid = pixelGrid :+ row
    }

    GrayscaleImage(pixelGrid)
  }
}
