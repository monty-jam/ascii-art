package models.images

import models.pixels.Pixel
import org.scalatest.FunSuite

class ImageTests extends FunSuite {

  val image = new Image(Seq(
    Seq(new Pixel[Int](1), new Pixel[Int](2), new Pixel[Int](3)),
    Seq(new Pixel[Int](4), new Pixel[Int](5), new Pixel[Int](6))
  ))

  test("Creating simple correct image") {
    assert(image.getHeight == 2)
    assert(image.getWidth == 3)
    assert(image.getPixel(0, 0).getValue == 1)
    assert(image.getPixel(0, 1).getValue == 2)
    assert(image.getPixel(0, 2).getValue == 3)
    assert(image.getPixel(1, 0).getValue == 4)
    assert(image.getPixel(1, 1).getValue == 5)
    assert(image.getPixel(1, 2).getValue == 6)
  }

  test("Trying to create image with 0 height") {
    assertThrows[Exception](new Image(Seq(Seq())))
  }

  test("Trying to create image with 0 width") {
      assertThrows[Exception](new Image(Seq(
        Seq(new Pixel[Int](1)),
        Seq())))
  }

  test("Trying to create image with different row sizes") {
    assertThrows[Exception](new Image(Seq(
      Seq(new Pixel[Int](1), new Pixel[Int](2)),
      Seq(new Pixel[Int](3), new Pixel[Int](4), new Pixel[Int](5))
    )))
  }

  test("Getting pixels out of bounds") {
    assertThrows[Exception](image.getPixel(-1, 0))
    assertThrows[Exception](image.getPixel(0, -1))
    assertThrows[Exception](image.getPixel(2, 0))
    assertThrows[Exception](image.getPixel(0, 3))
  }
}
