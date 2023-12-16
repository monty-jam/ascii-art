package Models.Images

import Models.Pixels.AsciiPixel

case class AsciiImage(override val pixelGrid: Seq[Seq[AsciiPixel]]) extends Image(pixelGrid) {
}
