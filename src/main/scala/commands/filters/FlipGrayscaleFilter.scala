package commands.filters

import models.Images.GrayscaleImage
import models.Pixels.GrayscalePixel

trait FlipGrayscaleFilter extends GrayscaleFilter {

  protected def flip(y: Int, x: Int, height: Int, width: Int): (Int, Int)

  override final def filter(source: GrayscaleImage): GrayscaleImage = {
    for (y <- 0 until source.getHeight) {
      var row: List[GrayscalePixel] = List()
      for (x <- 0 until source.getWidth) {
        val flipResult = flip(y, x, source.getHeight, source.getWidth)
        val pixelValue = source.getPixel(flipResult._1, flipResult._2).getValue

        row = row :+ GrayscalePixel(pixelValue)
      }
      pixelGrid = pixelGrid :+ row
    }

    GrayscaleImage(pixelGrid)
  }
}
