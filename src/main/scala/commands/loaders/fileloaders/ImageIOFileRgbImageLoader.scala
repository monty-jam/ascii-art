package commands.loaders.fileloaders

import models.images.RgbImage
import models.filepaths.FilePath
import models.pixels.RgbPixel

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

class ImageIOFileRgbImageLoader(override val filePath: FilePath) extends FileRgbImageLoader[BufferedImage](filePath) {
  override protected def readFile(): BufferedImage = {
    try {
      ImageIO.read(new File(filePath.getFilePathValue))
    }
    catch {
      case _: Exception => throw new Exception("File " + filePath.getFilePathValue + " can't be read.")
    }
  }

  override def load(): RgbImage = {
    val file = new File(filePath.getFilePathValue)
    if (!file.isFile) {
      throw new Exception("File can't be reached for loading.")
    }

    val image = readFile()
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
