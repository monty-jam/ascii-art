package models.images

import models.pixels.RgbPixel
import org.scalatest.FunSuite

class RgbImageTests extends FunSuite {
  val image = new Image(Seq(
    Seq(RgbPixel(0xFF0000), RgbPixel(0xFFFF00), RgbPixel(0x00FF00)),
    Seq(RgbPixel(0x00FFFF), RgbPixel(0x000000), RgbPixel(0xFFFFFF))
  ))

  test("Creating simple correct image") {
    assert(image.getHeight == 2)
    assert(image.getWidth == 3)
    assert(image.getPixel(0, 0).getValue == 0xFF0000)
    assert(image.getPixel(0, 1).getValue == 0xFFFF00)
    assert(image.getPixel(0, 2).getValue == 0x00FF00)
    assert(image.getPixel(1, 0).getValue == 0x00FFFF)
    assert(image.getPixel(1, 1).getValue == 0x000000)
    assert(image.getPixel(1, 2).getValue == 0xFFFFFF)
  }

  test("Trying to create image with 0 height") {
    assertThrows[Exception](new Image(Seq(Seq())))
  }

  test("Trying to create image with 0 width") {
    assertThrows[Exception](new Image(Seq(
      Seq(RgbPixel(0xFF0000)),
      Seq())))
  }

  test("Trying to create image with different row sizes") {
    assertThrows[Exception](new Image(Seq(
      Seq(RgbPixel(0xFF0000), RgbPixel(0xFFFF00)),
      Seq(RgbPixel(0x00FFFF), RgbPixel(0x000000), RgbPixel(0xFFFFFF))
    )))
  }

  test("Getting pixels out of bounds") {
    assertThrows[Exception](image.getPixel(-1, 0))
    assertThrows[Exception](image.getPixel(0, -1))
    assertThrows[Exception](image.getPixel(2, 0))
    assertThrows[Exception](image.getPixel(0, 3))
  }

}
