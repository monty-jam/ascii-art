package Commands.Filters

import Models.Images.GrayscaleImage
import Models.Pixels.GrayscalePixel

trait GrayscaleFilter extends Filter[GrayscaleImage] {
  var pixelGrid: List[List[GrayscalePixel]] = List()
}
