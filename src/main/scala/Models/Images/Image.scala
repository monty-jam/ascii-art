package Models.Images

import Models.Pixels.Pixel

class Image[T] (protected val pixelGrid: Seq[Seq[Pixel[T]]]) {
  if (pixelGrid.isEmpty)
    throw new Exception("0 image height is restricted.")

  if (pixelGrid.exists(e => e.isEmpty))
    throw new Exception("0 image width is restricted.")

  protected val height: Int = pixelGrid.length
  protected val width: Int = pixelGrid.head.length

  if (pixelGrid.exists(e => e.length != width))
    throw new Exception("Some rows of an image are different size.")

  def getHeight: Int = height
  def getWidth: Int = width
  def getPixel(row: Int, column: Int): Pixel[T] = {
    if (row > height - 1 || row < 0)
      throw new Exception("y coordinate is out of bounds.")

    if (column > width - 1 || column < 0)
      throw new Exception("x coordinate is out of bounds.")

    pixelGrid(row)(column)
  }
}
