package Models

case class AsciiImage(override val pixelGrid: Seq[Seq[Char]]) extends Image[Char](pixelGrid) {

}
