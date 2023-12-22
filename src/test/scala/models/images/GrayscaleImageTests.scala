package models.images

import models.pixels.GrayscalePixel
import org.scalatest.FunSuite

class GrayscaleImageTests extends FunSuite {
  val image = new Image(Seq(
    Seq(GrayscalePixel(0), GrayscalePixel(50), GrayscalePixel(100)),
    Seq(GrayscalePixel(150), GrayscalePixel(200), GrayscalePixel(250))
  ))

  test("Creating simple correct image") {
    assert(image.getHeight == 2)
    assert(image.getWidth == 3)
    assert(image.getPixel(0, 0).getValue == 0)
    assert(image.getPixel(0, 1).getValue == 50)
    assert(image.getPixel(0, 2).getValue == 100)
    assert(image.getPixel(1, 0).getValue == 150)
    assert(image.getPixel(1, 1).getValue == 200)
    assert(image.getPixel(1, 2).getValue == 250)
  }

  test("Trying to create image with 0 height") {
    assertThrows[Exception](new Image(Seq(Seq())))
  }

  test("Trying to create image with 0 width") {
    assertThrows[Exception](new Image(Seq(
      Seq(GrayscalePixel(0)),
      Seq())))
  }

  test("Trying to create image with different row sizes") {
    assertThrows[Exception](new Image(Seq(
      Seq(GrayscalePixel(0), GrayscalePixel(50)),
      Seq(GrayscalePixel(150), GrayscalePixel(200), GrayscalePixel(250))
    )))
  }

  test("Getting pixels out of bounds") {
    assertThrows[Exception](image.getPixel(-1, 0))
    assertThrows[Exception](image.getPixel(0, -1))
    assertThrows[Exception](image.getPixel(2, 0))
    assertThrows[Exception](image.getPixel(0, 3))
  }
}
