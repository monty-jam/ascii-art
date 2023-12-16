package Models.Pixels

case class GrayscalePixel (override val value: Float) extends Pixel(value) {
  if (this.value < 0 || this.value > 255) {
    throw new Exception("Invalid grayscale pixel value.")
  }
}
