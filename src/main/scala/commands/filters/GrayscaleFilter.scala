package commands.filters

import models.Images.GrayscaleImage
import models.Pixels.GrayscalePixel

trait GrayscaleFilter extends Filter[GrayscaleImage] {
  var pixelGrid: List[List[GrayscalePixel]] = List()
}
