package models.Pixels

case class GrayscalePixel (override val value: Int) extends Pixel(value) {
  if (this.value < 0 || this.value > 255) {
    throw new Exception("Invalid grayscale pixel value.")
  }
}
