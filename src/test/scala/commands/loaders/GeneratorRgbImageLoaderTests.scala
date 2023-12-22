package commands.loaders

import models.images.RgbImage
import models.pixels.Pixel
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
