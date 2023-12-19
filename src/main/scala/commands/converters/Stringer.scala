package commands.converters

import models.Images.AsciiImage

class Stringer extends Converter[AsciiImage, String] {
  override def convert(source: AsciiImage): String = {
    var pixelGrid = ""

    for (y <- 0 until source.getHeight) {
      var row = ""
      for (x <- 0 until source.getWidth) {
        row += source.getPixel(y, x).getValue
      }
      row += '\n'
      pixelGrid += row
    }

    pixelGrid
  }
}
