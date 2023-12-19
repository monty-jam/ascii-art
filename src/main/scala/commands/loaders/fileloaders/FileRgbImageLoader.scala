package commands.loaders.fileloaders

import commands.loaders.RgbImageLoader
import models.Images.RgbImage
import models.PathFiles.FilePath

abstract class FileRgbImageLoader[T](override val filePath: FilePath) extends FileLoader[T, RgbImage](filePath) with RgbImageLoader {

}
