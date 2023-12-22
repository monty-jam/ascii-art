package commands.converters.symbolers

import models.images.{AsciiImage, GrayscaleImage}
import models.pixels.{AsciiPixel, GrayscalePixel}
import org.scalatest.FunSuite

class NonLinearSymbolerTests extends FunSuite {

  def converted(source: GrayscaleImage): AsciiImage = {
    new NonLinearSymboler().convert(source)
  }

  val grayscaleImage: GrayscaleImage = GrayscaleImage(Seq(
    Seq(GrayscalePixel(24), GrayscalePixel(49), GrayscalePixel(74), GrayscalePixel(99), GrayscalePixel(124)),
    Seq(GrayscalePixel(149), GrayscalePixel(174), GrayscalePixel(199), GrayscalePixel(224), GrayscalePixel(249))
  ))

  val nonLinearAsciiImage: AsciiImage = AsciiImage(Seq(
    Seq(AsciiPixel('+'), AsciiPixel('+'), AsciiPixel('+'), AsciiPixel('+'), AsciiPixel('+')),
    Seq(AsciiPixel('+'), AsciiPixel('='), AsciiPixel('='), AsciiPixel('.'), AsciiPixel('.'))
  ))

  test("NonLinear conversion") {
    val source = grayscaleImage
    val result = nonLinearAsciiImage
    assert(converted(source) == result)
  }

  test("NonLinear conversion, checking value edges") {
    val source = GrayscaleImage(Seq(Seq(GrayscalePixel(150), GrayscalePixel(200), GrayscalePixel(255))))
    val result = AsciiImage(Seq(Seq(AsciiPixel('+'), AsciiPixel('='), AsciiPixel('.'))))
    assert(converted(source) == result)
  }
}
