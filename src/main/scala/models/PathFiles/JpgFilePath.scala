package models.PathFiles

case class JpgFilePath(override val filePathValue: String) extends FilePath(filePathValue) {
  if (filePathValue.split('.').last != "jpg") {
    throw new Exception("Invalid jpg file path.")
  }
}
