package commands.filters

import models.images.GrayscaleImage
import models.pixels.GrayscalePixel
import org.scalatest.FunSuite

class InverseGrayscaleFilterTests extends FunSuite {
  def filtered(source: GrayscaleImage): GrayscaleImage = {
    new InverseGrayscaleFilter().filter(source)
  }

  val grayscaleImage: GrayscaleImage = GrayscaleImage(Seq(
      Seq(GrayscalePixel(24), GrayscalePixel(49), GrayscalePixel(74), GrayscalePixel(99), GrayscalePixel(124)),
      Seq(GrayscalePixel(149), GrayscalePixel(174), GrayscalePixel(199), GrayscalePixel(224), GrayscalePixel(249))
  ))

  val inverseGrayscaleImage: GrayscaleImage = GrayscaleImage(Seq(
      Seq(GrayscalePixel(231), GrayscalePixel(206), GrayscalePixel(181), GrayscalePixel(156), GrayscalePixel(131)),
      Seq(GrayscalePixel(106), GrayscalePixel(81), GrayscalePixel(56), GrayscalePixel(31), GrayscalePixel(6))
  ))

  test("Common inverse filter") {
    val source = grayscaleImage
    val result = inverseGrayscaleImage
    assert(filtered(source) == result)
  }

  val blackGrayscaleImage: GrayscaleImage = GrayscaleImage(Seq(
      Seq(GrayscalePixel(0), GrayscalePixel(0), GrayscalePixel(0), GrayscalePixel(0), GrayscalePixel(0)),
      Seq(GrayscalePixel(0), GrayscalePixel(0), GrayscalePixel(0), GrayscalePixel(0), GrayscalePixel(0))
  ))

  val whiteGrayscaleImage: GrayscaleImage = GrayscaleImage(Seq(
      Seq(GrayscalePixel(255), GrayscalePixel(255), GrayscalePixel(255), GrayscalePixel(255), GrayscalePixel(255)),
      Seq(GrayscalePixel(255), GrayscalePixel(255), GrayscalePixel(255), GrayscalePixel(255), GrayscalePixel(255))
  ))

  test("Full inverse filter from black to white") {
    val source = blackGrayscaleImage
    val result = whiteGrayscaleImage
    assert(filtered(source) == result)
  }

  test("Full inverse filter from white to black") {
    val source = whiteGrayscaleImage
    val result = blackGrayscaleImage
    assert(filtered(source) == result)
  }
}
