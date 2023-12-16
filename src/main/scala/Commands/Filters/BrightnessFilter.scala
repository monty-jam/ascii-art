package Commands.Filters

import Models.Images.GrayscaleImage
import Models.Pixels.GrayscalePixel

class BrightnessFilter(brightness: Int) extends GrayscaleFilter {

  override def filter(source: GrayscaleImage): GrayscaleImage = {
    for (y <- 0 until source.getHeight) {
      var row: List[GrayscalePixel] = List()
      for (x <- 0 until source.getWidth) {
        var pixelValue = source.getPixel(y, x).getValue + brightness
        if (pixelValue > 255)
          pixelValue = 255
        else if (pixelValue < 0)
          pixelValue = 0

        row = row :+ GrayscalePixel(pixelValue)
      }
      pixelGrid = pixelGrid :+ row
    }

    GrayscaleImage(pixelGrid)
  }
}
