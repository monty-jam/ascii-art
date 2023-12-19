package models.Images

import models.Pixels.RgbPixel

case class RgbImage(override val pixelGrid: Seq[Seq[RgbPixel]]) extends Image(pixelGrid) {
}