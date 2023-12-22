package commands.loaders

import commands.loaders.fileloaders.JpgRgbImageLoader
import models.filepaths.JpgFilePath
import models.images.RgbImage
import org.scalatest.FunSuite

class JpgRgbImageLoaderTests extends FunSuite {

  def loaded(jpgFilePath: JpgFilePath): RgbImage = {
    new JpgRgbImageLoader(jpgFilePath).load()
  }

  test("Load black and white jpg") {
    val result = loaded(JpgFilePath("examples/blackWhite.jpg"))
    //    assert(result.getPixel(0, 0).getValue == new Color(0x000000).getRGB)
    //    assert(result.getPixel(0, 1).getValue == new Color(0xFFFFFF).getRGB)
  }

  test("Load non-existent jpg file") {
    assertThrows[Exception](loaded(JpgFilePath("examples/nonExistentFile.jpg")))
  }

}
