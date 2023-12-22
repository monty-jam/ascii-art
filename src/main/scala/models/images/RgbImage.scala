package models.images

import models.pixels.RgbPixel

case class RgbImage(override val pixelGrid: Seq[Seq[RgbPixel]]) extends Image(pixelGrid) {
}