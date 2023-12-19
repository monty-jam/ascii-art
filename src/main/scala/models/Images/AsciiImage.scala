package models.Images

import models.Pixels.AsciiPixel

case class AsciiImage(override val pixelGrid: Seq[Seq[AsciiPixel]]) extends Image(pixelGrid) {
}
