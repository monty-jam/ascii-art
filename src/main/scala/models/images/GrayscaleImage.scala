package models.images

import models.pixels.GrayscalePixel

case class GrayscaleImage(override val pixelGrid: Seq[Seq[GrayscalePixel]]) extends Image(pixelGrid) {
}
