package commands.filters

import models.Images.GrayscaleImage
import models.Pixels.GrayscalePixel
import org.scalatest.FunSuite

class BrightnessGrayscaleFilterTests extends FunSuite {

  def filtered(brightness: Int, source: GrayscaleImage): GrayscaleImage = {
    new BrightnessGrayscaleFilter(brightness).filter(source)
  }

  val grayscaleImage: GrayscaleImage = GrayscaleImage(Seq(
    Seq(GrayscalePixel(24), GrayscalePixel(49), GrayscalePixel(74), GrayscalePixel(99), GrayscalePixel(124)),
    Seq(GrayscalePixel(149), GrayscalePixel(174), GrayscalePixel(199), GrayscalePixel(224), GrayscalePixel(249))
  ))

  val brighterGrayscaleImage: GrayscaleImage = GrayscaleImage(Seq(
    Seq(GrayscalePixel(74), GrayscalePixel(99), GrayscalePixel(124), GrayscalePixel(149), GrayscalePixel(174)),
    Seq(GrayscalePixel(199), GrayscalePixel(224), GrayscalePixel(249), GrayscalePixel(255), GrayscalePixel(255))
  ))

  test("Brightness filter with brightness 50") {
    val source = grayscaleImage
    val result = brighterGrayscaleImage
    assert(filtered(50, source) == result)
  }

  val darkerGrayscaleImage: GrayscaleImage = GrayscaleImage(Seq(
    Seq(GrayscalePixel(0), GrayscalePixel(0), GrayscalePixel(24), GrayscalePixel(49), GrayscalePixel(74)),
    Seq(GrayscalePixel(99), GrayscalePixel(124), GrayscalePixel(149), GrayscalePixel(174), GrayscalePixel(199))
  ))

  test("Brightness filter with brightness -50") {
    val source = grayscaleImage
    val result = darkerGrayscaleImage
    assert(filtered(-50, source) == result)
  }

  test("Brightness filter with brightness 0") {
    val source = grayscaleImage
    val result = grayscaleImage
    assert(filtered(0, source) == result)
  }

  val fullBrightGrayscaleImage: GrayscaleImage = GrayscaleImage(Seq(
    Seq(GrayscalePixel(255), GrayscalePixel(255), GrayscalePixel(255), GrayscalePixel(255), GrayscalePixel(255)),
    Seq(GrayscalePixel(255), GrayscalePixel(255), GrayscalePixel(255), GrayscalePixel(255), GrayscalePixel(255))
  ))

  test("Trying to overflow grayscalePixel Int values") {
    val source = grayscaleImage
    val result = fullBrightGrayscaleImage
    assert(filtered(Int.MaxValue, source) == result)
  }
}
