package Models.Images

import Models.Pixels.GrayscalePixel

case class GrayscaleImage(override val pixelGrid: Seq[Seq[GrayscalePixel]]) extends Image(pixelGrid) {
}
