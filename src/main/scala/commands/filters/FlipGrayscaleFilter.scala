package commands.filters

import models.images.GrayscaleImage
import models.pixels.GrayscalePixel

import scala.annotation.meta.param

/**
 * Filter that flips a Grayscale Image
 */
trait FlipGrayscaleFilter extends GrayscaleFilter {

  /**
   * Method that correctly flips the coordinates of a pixel
   * Every Flip Filter subclass must implement this method differently
   * and call it in filter(source: GrayscaleImage) method
   * @param y the y coordinate of the pixel
   * @param x the x coordinate of the pixel
   * @param height the height of the image
   * @param width the width of the image
   * @return the pair of flipped coordinates
   */
  protected def flip(y: Int, x: Int, height: Int, width: Int): (Int, Int)

  override final def filter(source: GrayscaleImage): GrayscaleImage = {
    for (y <- 0 until source.getHeight) {
      var row: List[GrayscalePixel] = List()
      for (x <- 0 until source.getWidth) {
        val flipResult = flip(y, x, source.getHeight, source.getWidth)
        val pixelValue = source.getPixel(flipResult._1, flipResult._2).getValue

        row = row :+ GrayscalePixel(pixelValue)
      }
      pixelGrid = pixelGrid :+ row
    }

    GrayscaleImage(pixelGrid)
  }
}
