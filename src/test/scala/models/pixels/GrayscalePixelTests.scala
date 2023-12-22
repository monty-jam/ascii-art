package models.pixels

import models.filepaths.JpgFilePath
import org.scalatest.FunSuite

class GrayscalePixelTests extends FunSuite {
  test("Creating correct GrayscalePixel") {
    val pixel = GrayscalePixel(120)
    assert(pixel.getValue == 120)
  }

  test("Creating correct GrayscalePixel, max edge") {
    val pixel = GrayscalePixel(255)
    assert(pixel.getValue == 255)
  }

  test("Creating correct GrayscalePixel, min edge") {
    val pixel = GrayscalePixel(0)
    assert(pixel.getValue == 0)
  }

  test("Creating incorrect GrayscalePixel, negative value") {
    assertThrows[Exception](GrayscalePixel(256))
  }

  test("Creating incorrect GrayscalePixel, over max edge") {
    assertThrows[Exception](GrayscalePixel(256))
  }
}
