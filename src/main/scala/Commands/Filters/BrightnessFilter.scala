package Commands.Filters

import Models.{AsciiImage, GrayscaleImage}

class BrightnessFilter(brightness: Int) extends GrayscaleFilter {

  override def filter(source: GrayscaleImage): GrayscaleImage = {
    for (y <- 0 until source.getHeight) {
      var row: List[Float] = List()
      for (x <- 0 until source.getWidth) {
        var pixel = source.getPixel(y, x) + brightness
        if (pixel > 255)
          pixel = 255
        else if (pixel < 0)
          pixel = 0

        row = row :+ pixel
      }
      pixelGrid = pixelGrid :+ row
    }

    GrayscaleImage(pixelGrid)
  }
}
