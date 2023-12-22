package commands.converters

import models.images.{GrayscaleImage, RgbImage}
import models.pixels.{GrayscalePixel, RgbPixel}
import org.scalatest.FunSuite


class GrayscalerTests extends FunSuite {

  def converted(source: RgbImage): GrayscaleImage = {
    new Grayscaler().convert(source)
  }

  val rainbowRgbImage: RgbImage = RgbImage(Seq(
    Seq(RgbPixel(0xFF0000), RgbPixel(0xFF7F00), RgbPixel(0xFFFF00), RgbPixel(0x00FF00), RgbPixel(0x00FFFF),
      RgbPixel(0x0000FF), RgbPixel(0x4B0082))
  ))

  val rainbowGrayscaleImage: GrayscaleImage = GrayscaleImage(Seq(
    Seq(GrayscalePixel(76), GrayscalePixel(151), GrayscalePixel(226), GrayscalePixel(150), GrayscalePixel(178),
      GrayscalePixel(28), GrayscalePixel(36))
  ))

  test("Convert rainbow from Rgb to Grayscale") {
    val source = rainbowRgbImage
    val result = rainbowGrayscaleImage
    assert(converted(source) == result)
  }

  val blackWhiteRgbImage: RgbImage = RgbImage(Seq(
      Seq(RgbPixel(0x000000), RgbPixel(0xFFFFFF))
  ))

  val blackWhiteGrayscaleImage: GrayscaleImage = GrayscaleImage(Seq(
      Seq(GrayscalePixel(0), GrayscalePixel(255))
  ))

  test("Convert full black and full white from Rgb to Grayscale") {
    val source = blackWhiteRgbImage
    val result = blackWhiteGrayscaleImage
    assert(converted(source) == result)
  }
}
