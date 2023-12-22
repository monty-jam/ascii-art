package models.pixels

import org.scalatest.FunSuite

class AsciiPixelTests extends FunSuite {
  test("Creating simple correct AsciiPixel") {
    val pixel = AsciiPixel('a')
    assert(pixel.getValue == 'a')
  }
}
