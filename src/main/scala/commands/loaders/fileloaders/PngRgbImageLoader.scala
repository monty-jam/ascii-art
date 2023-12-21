package commands.loaders.fileloaders

import models.FilePaths.PngFilePath

class PngRgbImageLoader(override val filePath: PngFilePath) extends ImageIOFileRgbImageLoader(filePath) {

}
