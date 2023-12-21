package commands.loaders

import models.Images.RgbImage
import models.Pixels.Pixel
import org.scalatest.FunSuite

class GeneratorRgbImageLoaderTests extends FunSuite {
  def loaded(): RgbImage = {
    new GeneratorRgbImageLoader().load()
  }

  test("Generator doesn't generate empty RgbImage") {
    val result = loaded()
    assert(result.getWidth > 0 && result.getHeight > 0)
    assert(result.getPixel(0, 0).isInstanceOf[Pixel[Int]])
  }
}
