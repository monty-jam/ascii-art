package models.pixels

class Pixel[T] (protected val value: T) {
  def getValue: T = value
}
