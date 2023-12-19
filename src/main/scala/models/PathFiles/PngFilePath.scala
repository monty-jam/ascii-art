package models.PathFiles

case class PngFilePath(override val filePathValue: String) extends FilePath(filePathValue) {
  if (filePathValue.split('.').last != "png") {
    throw new Exception("Invalid png file path.")
  }
}