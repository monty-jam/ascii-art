package Commands.Loaders

import Models.RgbImage

class GeneratorRgbImageLoader extends RgbImageLoader {
  override def load(): RgbImage = {
    var pixelGrid: List[List[Int]] = List()

    val rand = scala.util.Random
    val height = rand.between(50, 200)
    val width = rand.between(50, 200)

    for (y <- 0 until height) {
      var row: List[Int] = List()
      for (x <- 0 until width) {
        val pixel = (rand.between(0, 255) << 24) | (rand.between(0, 255) << 16) | (rand.between(0, 255) << 8) | rand.between(0, 255)
        row = row :+ pixel
      }
      pixelGrid = pixelGrid :+ row
    }

    RgbImage(pixelGrid)
  }
}
