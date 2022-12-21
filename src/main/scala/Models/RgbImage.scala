package Models

case class RgbImage(override val pixelGrid: Seq[Seq[Int]]) extends Image[Int](pixelGrid) {

}