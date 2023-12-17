package Commands.Filters

import Commands.Filters.Axis.Axis
import Models.Images.GrayscaleImage
import Models.Pixels.GrayscalePixel

class FlipGrayscaleFilter(axis: Axis) extends GrayscaleFilter {

  override def filter(source: GrayscaleImage): GrayscaleImage = {
    for (y <- 0 until source.getHeight) {
      var row: List[GrayscalePixel] = List()
      for (x <- 0 until source.getWidth) {
        var pixelValue = 0.toFloat
        if (axis == Axis.X) {
          pixelValue = source.getPixel(source.getHeight - y - 1, x).getValue
        } else { // (axis == Axis.Y)
          pixelValue = source.getPixel(y, source.getWidth - x - 1).getValue
        }

        row = row :+ GrayscalePixel(pixelValue)
      }
      pixelGrid = pixelGrid :+ row
    }

    GrayscaleImage(pixelGrid)
  }
}
