package commands.filters

import models.images.GrayscaleImage
import models.pixels.GrayscalePixel

trait GrayscaleFilter extends Filter[GrayscaleImage] {
  var pixelGrid: List[List[GrayscalePixel]] = List()
}
