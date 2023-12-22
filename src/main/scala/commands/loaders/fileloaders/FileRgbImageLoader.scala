package commands.loaders.fileloaders

import commands.loaders.RgbImageLoader
import models.filepaths.FilePath
import models.images.RgbImage

abstract class FileRgbImageLoader[T](override val filePath: FilePath) extends FileLoader[T, RgbImage](filePath) with RgbImageLoader {

}
