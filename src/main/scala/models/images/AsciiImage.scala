package models.images

import models.pixels.AsciiPixel

case class AsciiImage(override val pixelGrid: Seq[Seq[AsciiPixel]]) extends Image(pixelGrid) {
}
