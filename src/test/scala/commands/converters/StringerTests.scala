package commands.converters

import models.Images.AsciiImage
import models.Pixels.AsciiPixel
import org.scalatest.FunSuite


class StringerTests extends FunSuite {

  val paulBorkesAsciiImage: AsciiImage = AsciiImage(Seq(
    Seq(AsciiPixel('@'), AsciiPixel('%'), AsciiPixel('#'), AsciiPixel('*'), AsciiPixel('+')),
    Seq(AsciiPixel('='), AsciiPixel('-'), AsciiPixel(':'), AsciiPixel('.'), AsciiPixel(' '))
  ))

  test("paul Borkes Ascii Image to String") {
    val stringer = new Stringer()
    val source = paulBorkesAsciiImage
    val result = "@%#*+\n=-:. \n"
    assert(stringer.convert(source) == result)
  }

  val customTableAsciiImage: AsciiImage = AsciiImage(Seq(
    Seq(AsciiPixel('.'), AsciiPixel('.'), AsciiPixel('.'), AsciiPixel('.'), AsciiPixel('.')),
    Seq(AsciiPixel('.'), AsciiPixel('.'), AsciiPixel('.'), AsciiPixel('.'), AsciiPixel('.'))
  ))

  test("full dot Ascii Image to String") {
    val stringer = new Stringer()
    val source = customTableAsciiImage
    val result = ".....\n.....\n"
    assert(stringer.convert(source) == result)
  }

  val nonLinearAsciiImage: AsciiImage = AsciiImage(Seq(
    Seq(AsciiPixel('+'), AsciiPixel('+'), AsciiPixel('+'), AsciiPixel('+'), AsciiPixel('+')),
    Seq(AsciiPixel('+'), AsciiPixel('='), AsciiPixel('='), AsciiPixel('.'), AsciiPixel('.'))
  ))

  test("non linear Ascii Image to String") {
      val stringer = new Stringer()
      val source = nonLinearAsciiImage
      val result = "+++++\n+==..\n"
      assert(stringer.convert(source) == result)
  }
}
