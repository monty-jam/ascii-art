package Commands.Filters

import Models.{AsciiImage, GrayscaleImage}

trait GrayscaleFilter extends Filter[GrayscaleImage] {
  var pixelGrid: List[List[Float]] = List()
}
