package Commands.Loaders

import Models.Images.RgbImage
import Models.Pixels.RgbPixel

class GeneratorRgbImageLoader extends RgbImageLoader {
  override def load(): RgbImage = {
    var pixelGrid: List[List[RgbPixel]] = List()

    val rand = scala.util.Random
    val height = rand.between(50, 200)
    val width = rand.between(50, 200)

    for (y <- 0 until height) {
      var row: List[RgbPixel] = List()
      for (x <- 0 until width) {
        val pixel = RgbPixel((rand.between(0, 255) << 24) | (rand.between(0, 255) << 16) | (rand.between(0, 255) << 8) | rand.between(0, 255))
        row = row :+ pixel
      }
      pixelGrid = pixelGrid :+ row
    }

    RgbImage(pixelGrid)
  }
}
