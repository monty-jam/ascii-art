package Models

case class GrayscaleImage(override val pixelGrid: Seq[Seq[Float]]) extends Image[Float](pixelGrid) {
  for (y <- 0 until height)
    for (x <- 0 until width) {
      if (this.getPixel(y, x) < 0 || this.getPixel(y, x) > 255) {
        throw new Exception("Invalid grayscale value.")
      };
    }
}
