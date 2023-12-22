package commands.filters

import models.images.GrayscaleImage
import models.pixels.GrayscalePixel

class InverseGrayscaleFilter extends GrayscaleFilter {

  override def filter(source: GrayscaleImage): GrayscaleImage = {
    for (y <- 0 until source.getHeight) {
      var row: List[GrayscalePixel] = List()
      for (x <- 0 until source.getWidth) {
        val pixelValue = 255 - source.getPixel(y, x).getValue

        row = row :+ GrayscalePixel(pixelValue)
      }
      pixelGrid = pixelGrid :+ row
    }

    GrayscaleImage(pixelGrid)
  }
}
