package models.images

import models.pixels.{AsciiPixel, Pixel}
import org.scalatest.FunSuite

class AsciiImageTests extends FunSuite {

  test("Creating simple correct AsciiPixel") {
    val pixel = AsciiPixel('a')
    assert(pixel.getValue == 'a')
  }

  val image = new Image(Seq(
    Seq(AsciiPixel('a'), AsciiPixel('b'), AsciiPixel('c')),
    Seq(AsciiPixel('d'), AsciiPixel('e'), AsciiPixel('f'))
  ))

  test("Creating correct AsciiImage") {
    assert(image.getHeight == 2)
    assert(image.getWidth == 3)
    assert(image.getPixel(0, 0).getValue == 'a')
    assert(image.getPixel(0, 1).getValue == 'b')
    assert(image.getPixel(0, 2).getValue == 'c')
    assert(image.getPixel(1, 0).getValue == 'd')
    assert(image.getPixel(1, 1).getValue == 'e')
    assert(image.getPixel(1, 2).getValue == 'f')
  }

    test("Trying to create AsciiImage with 0 height") {
        assertThrows[Exception](AsciiImage(Seq(Seq())))
    }

    test("Trying to create AsciiImage with 0 width") {
        assertThrows[Exception](AsciiImage(Seq(
            Seq(AsciiPixel('a')),
            Seq())))
    }

    test("Trying to create AsciiImage with different row sizes") {
        assertThrows[Exception](AsciiImage(Seq(
            Seq(AsciiPixel('a'), AsciiPixel('b')),
            Seq(AsciiPixel('c'), AsciiPixel('d'), AsciiPixel('e'))
        )))
    }

    test("Getting AsciiPixels out of bounds") {
        assertThrows[Exception](image.getPixel(-1, 0))
        assertThrows[Exception](image.getPixel(0, -1))
        assertThrows[Exception](image.getPixel(2, 0))
        assertThrows[Exception](image.getPixel(0, 3))
    }

}
