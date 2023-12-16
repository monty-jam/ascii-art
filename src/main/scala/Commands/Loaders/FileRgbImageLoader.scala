package Commands.Loaders

import Models.Images.{Image, RgbImage}
import Models.Pixels.RgbPixel

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.{IIOException, ImageIO}

class FileRgbImageLoader(pathFile: String) extends Loader[RgbImage] {

  private def getImage: BufferedImage = {
    try {
      ImageIO.read(new File(pathFile))
    }
    catch {
      case e: Exception => throw new Exception("File " + pathFile + " can't be read.")
    }
  }
  override def load(): RgbImage = {
    val file = new File(pathFile)
    if (!file.isFile) {
      throw new Exception("File can't be reached for loading.")
    }

    var image = getImage
    var pixelGrid: List[List[RgbPixel]] = List()

    for (y <- 0 until image.getHeight()) {
      var row: List[RgbPixel] = List()
      for (x <- 0 until image.getWidth()) {
        val pixel = RgbPixel(image.getRGB(x, image.getHeight() - y - 1))
        row = row :+ pixel
      }
      pixelGrid = row :: pixelGrid
    }

    RgbImage(pixelGrid)
  }
}
