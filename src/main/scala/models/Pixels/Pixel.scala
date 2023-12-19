package models.Pixels

class Pixel[T] (protected val value: T) {
  def getValue: T = value
}
