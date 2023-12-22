package commands.loaders

import commands.loaders.fileloaders.ImageIOFileRgbImageLoader
import models.filepaths.FilePath
import models.images.RgbImage
import org.scalatest.FunSuite

import java.awt.Color

class ImageIOFileRgbImageLoaderTests extends FunSuite {

  def loaded(filePath: FilePath): RgbImage = {
    new ImageIOFileRgbImageLoader(filePath).load()
  }

  test("Load some ImageIO file (png 1)") {
    val result = loaded(new FilePath("examples/rainbow.png"))
    assert(result.getPixel(0, 0).getValue == new Color(0xFF0000).getRGB)
    assert(result.getPixel(0, 1).getValue == new Color(0xFF7F00).getRGB)
    assert(result.getPixel(0, 2).getValue == new Color(0xFFFF00).getRGB)
    assert(result.getPixel(0, 3).getValue == new Color(0x00FF00).getRGB)
    assert(result.getPixel(0, 4).getValue == new Color(0x00FFFF).getRGB)
    assert(result.getPixel(0, 5).getValue == new Color(0x0000FF).getRGB)
    assert(result.getPixel(0, 6).getValue == new Color(0x4B0082).getRGB)
  }

  test("Load some ImageIO file (png 2)") {
    val result = loaded(new FilePath("examples/shadesOfGray.png"))
    assert(result.getPixel(0, 0).getValue == new Color(0x000000).getRGB)
    assert(result.getPixel(0, 1).getValue == new Color(0x1c1c1c).getRGB)
    assert(result.getPixel(0, 2).getValue == new Color(0x383838).getRGB)
    assert(result.getPixel(0, 3).getValue == new Color(0x545454).getRGB)
    assert(result.getPixel(0, 4).getValue == new Color(0x707070).getRGB)
    assert(result.getPixel(1, 0).getValue == new Color(0x8c8c8c).getRGB)
    assert(result.getPixel(1, 1).getValue == new Color(0xa8a8a8).getRGB)
    assert(result.getPixel(1, 2).getValue == new Color(0xc4c4c4).getRGB)
    assert(result.getPixel(1, 3).getValue == new Color(0xe0e0e0).getRGB)
    assert(result.getPixel(1, 4).getValue == new Color(0xfcfcfc).getRGB)
  }

  test("Load some ImageIO file (jpg)") {
    val result = loaded(new FilePath("examples/blackWhite.jpg"))
//    assert(result.getPixel(0, 0).getValue == new Color(0x000000).getRGB)
//    assert(result.getPixel(0, 1).getValue == new Color(0xFFFFFF).getRGB)
  }

  test("Load non-existent file with incorrect filePath") {
    assertThrows[Exception](loaded(new FilePath("examples/nonExistentFile")))
  }

}
