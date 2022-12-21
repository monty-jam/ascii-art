package Commands.Filters

import Models.{AsciiImage, GrayscaleImage}

class FlipFilter(axis: String) extends GrayscaleFilter {
  if (axis != 'x' || axis != 'y')
    throw new Exception("Invalid axis argument for --flip.")

  override def filter(source: GrayscaleImage): GrayscaleImage = {
    for (y <- 0 until source.getHeight) {
      var row: List[Float] = List()
      for (x <- 0 until source.getWidth) {
        var pixel = 0.toFloat
        if (axis == "x") {
          pixel = source.getPixel(source.getHeight - y - 1, x)
        } else { // (axis == "y")
          pixel = source.getPixel(y, source.getWidth - x - 1)
        }

        row = row :+ pixel
      }
      pixelGrid = pixelGrid :+ row
    }

    GrayscaleImage(pixelGrid)
  }
}
