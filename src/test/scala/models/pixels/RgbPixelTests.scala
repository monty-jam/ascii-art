package models.pixels

import org.scalatest.FunSuite

class RgbPixelTests extends FunSuite {
  test("Creating simple correct RgbPixel") {
    val pixel = RgbPixel(0xFF0000)
    assert(pixel.getValue == 0xFF0000)
  }

}
