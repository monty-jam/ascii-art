package commands.filters

import models.images.GrayscaleImage
import models.pixels.GrayscalePixel
import org.scalatest.FunSuite

class YAxisFlipGrayscaleFilterTests extends FunSuite {

  def filtered(source: GrayscaleImage): GrayscaleImage = {
    new YAxisFlipGrayscaleFilter().filter(source)
  }

  test("Flipping even image in Y axis") {
        val source = GrayscaleImage(List(
          List(GrayscalePixel(1), GrayscalePixel(2), GrayscalePixel(3), GrayscalePixel(4)),
          List(GrayscalePixel(5), GrayscalePixel(6), GrayscalePixel(7), GrayscalePixel(8))
        ))

        val expected = GrayscaleImage(List(
          List(GrayscalePixel(4), GrayscalePixel(3), GrayscalePixel(2), GrayscalePixel(1)),
          List(GrayscalePixel(8), GrayscalePixel(7), GrayscalePixel(6), GrayscalePixel(5))
        ))

        assert(filtered(source) == expected)
  }

  test("Flipping odd image in Y axis") {
        val source = GrayscaleImage(List(
          List(GrayscalePixel(1), GrayscalePixel(2), GrayscalePixel(3)),
          List(GrayscalePixel(4), GrayscalePixel(5), GrayscalePixel(6)),
          List(GrayscalePixel(7), GrayscalePixel(8), GrayscalePixel(9))
        ))

        val expected = GrayscaleImage(List(
          List(GrayscalePixel(3), GrayscalePixel(2), GrayscalePixel(1)),
          List(GrayscalePixel(6), GrayscalePixel(5), GrayscalePixel(4)),
          List(GrayscalePixel(9), GrayscalePixel(8), GrayscalePixel(7))
        ))

        assert(filtered(source) == expected)
  }

  test("Flipping image of a one pixel") {
        val source = GrayscaleImage(List(
          List(GrayscalePixel(1))
        ))

        val expected = GrayscaleImage(List(
          List(GrayscalePixel(1))
        ))

        assert(filtered(source) == expected)
  }
}
