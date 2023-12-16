package Commands.Filters

import Models.Images.GrayscaleImage
import Models.Pixels.GrayscalePixel

class FlipFilter(axis: String) extends GrayscaleFilter {
  if (axis != 'x' || axis != 'y')
    throw new Exception("Invalid axis argument for --flip.")

  override def filter(source: GrayscaleImage): GrayscaleImage = {
    for (y <- 0 until source.getHeight) {
      var row: List[GrayscalePixel] = List()
      for (x <- 0 until source.getWidth) {
        var pixelValue = 0.toFloat
        if (axis == "x") {
          pixelValue = source.getPixel(source.getHeight - y - 1, x).getValue
        } else { // (axis == "y")
          pixelValue = source.getPixel(y, source.getWidth - x - 1).getValue
        }

        row = row :+ GrayscalePixel(pixelValue)
      }
      pixelGrid = pixelGrid :+ row
    }

    GrayscaleImage(pixelGrid)
  }
}
