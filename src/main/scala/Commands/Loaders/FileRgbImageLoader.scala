package Commands.Loaders

import Models.Images.RgbImage
import Models.PathFiles.FilePath

abstract class FileRgbImageLoader[T](override val filePath: FilePath) extends FileLoader[T, RgbImage](filePath) with RgbImageLoader {

}
