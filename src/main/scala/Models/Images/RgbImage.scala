package Models.Images

import Models.Pixels.RgbPixel

case class RgbImage(override val pixelGrid: Seq[Seq[RgbPixel]]) extends Image(pixelGrid) {
}