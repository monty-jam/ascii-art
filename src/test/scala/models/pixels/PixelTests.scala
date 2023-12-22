package models.pixels

import org.scalatest.FunSuite

class PixelTests extends FunSuite {

  test("Creating simple correct pixel") {
    val pixel = new Pixel[Int](1)
    assert(pixel.getValue == 1)
  }

  test("Creating simple correct pixel with negative value") {
    val pixel = new Pixel[Int](-1)
    assert(pixel.getValue == -1)
  }

  test("Creating simple correct pixel with zero value") {
    val pixel = new Pixel[Int](0)
    assert(pixel.getValue == 0)
  }

  test("Creating simple correct pixel with max value") {
    val pixel = new Pixel[Int](Int.MaxValue)
    assert(pixel.getValue == Int.MaxValue)
  }

  test("Creating simple correct pixel with min value") {
    val pixel = new Pixel[Int](Int.MinValue)
    assert(pixel.getValue == Int.MinValue)
  }

  test("Creating simple correct pixel with double value") {
    val pixel = new Pixel[Double](1.0)
    assert(pixel.getValue == 1.0)
  }

  test("Creating simple correct pixel with negative double value") {
    val pixel = new Pixel[Double](-1.0)
    assert(pixel.getValue == -1.0)
  }

  test("Creating simple correct pixel with zero double value") {
    val pixel = new Pixel[Double](0.0)
    assert(pixel.getValue == 0.0)
  }

  test("Creating simple correct pixel with max double value") {
    val pixel = new Pixel[Double](Double.MaxValue)
    assert(pixel.getValue == Double.MaxValue)
  }

  test("Creating simple correct pixel with min double value") {
    val pixel = new Pixel[Double](Double.MinValue)
    assert(pixel.getValue == Double.MinValue)
  }

  test("Creating simple correct pixel with float value") {
    val pixel = new Pixel[Float](1.0f)
    assert(pixel.getValue == 1.0f)
  }

  test("Creating simple correct pixel with negative float value") {
    val pixel = new Pixel[Float](-1.0f)
    assert(pixel.getValue == -1.0f)
  }

  test("Creating simple correct pixel with zero float value") {
    val pixel = new Pixel[Float](0.0f)
    assert(pixel.getValue == 0.0f)
  }

  test("Creating simple correct pixel with max float value") {
    val pixel = new Pixel[Float](Float.MaxValue)
    assert(pixel.getValue == Float.MaxValue)
  }
}
