package commands.converters.symbolers

import models.Images.{AsciiImage, GrayscaleImage}
import models.Pixels.{AsciiPixel, GrayscalePixel}
import org.scalatest.FunSuite

class LinearSymbolerTests extends FunSuite {

  def converted(symbols: String, source: GrayscaleImage): AsciiImage = {
    new LinearSymboler(symbols).convert(source)
  }

  val grayscaleImage: GrayscaleImage = GrayscaleImage(Seq(
    Seq(GrayscalePixel(24), GrayscalePixel(49), GrayscalePixel(74), GrayscalePixel(99), GrayscalePixel(124)),
    Seq(GrayscalePixel(149), GrayscalePixel(174), GrayscalePixel(199), GrayscalePixel(224), GrayscalePixel(249))
  ))

  val paulBorkesAsciiImage: AsciiImage = AsciiImage(Seq(
    Seq(AsciiPixel('@'), AsciiPixel('%'), AsciiPixel('#'), AsciiPixel('*'), AsciiPixel('+')),
    Seq(AsciiPixel('='), AsciiPixel('-'), AsciiPixel(':'), AsciiPixel('.'), AsciiPixel(' '))
  ))

  test("Linear Paul Borkes table") {
    val source = grayscaleImage
    val result = paulBorkesAsciiImage
    assert(converted(" .:-=+*#%@", source) == result)
  }

  val customTableAsciiImage: AsciiImage = AsciiImage(Seq(
    Seq(AsciiPixel('.'), AsciiPixel('.'), AsciiPixel('.'), AsciiPixel('.'), AsciiPixel('.')),
    Seq(AsciiPixel('.'), AsciiPixel('.'), AsciiPixel('.'), AsciiPixel('.'), AsciiPixel('.'))
  ))

  test("Linear custom table with only one symbol") {
    val source = grayscaleImage
    val result = customTableAsciiImage
    assert(converted(".", source) == result)
  }

  test("Linear custom table with zero symbols") {
    val source = grayscaleImage
    assertThrows[Exception](converted("", source))
  }
}
