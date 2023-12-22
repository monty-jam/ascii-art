package commands.filters

import models.images.GrayscaleImage


class XAxisFlipGrayscaleFilter extends FlipGrayscaleFilter {

  override protected def flip(y: Int, x: Int, height: Int, width: Int): (Int, Int) = {
    (height - y - 1, x)
  }

}
