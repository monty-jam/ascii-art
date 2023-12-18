package Commands.Filters

class YAxisFlipGrayscaleFilter extends FlipGrayscaleFilter {
  override protected def flip(y: Int, x: Int, height: Int, width: Int): (Int, Int) = {
    (y, width - x - 1)
  }

}
