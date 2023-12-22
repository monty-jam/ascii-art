package commands.loaders.fileloaders

import commands.loaders.RgbImageLoader
import models.images.RgbImage
import models.filepaths.FilePath

abstract class FileRgbImageLoader[T](override val filePath: FilePath) extends FileLoader[T, RgbImage](filePath) with RgbImageLoader {

}
