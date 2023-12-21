package commands.loaders.fileloaders

import models.FilePaths.JpgFilePath

class JpgRgbImageLoader(override val filePath: JpgFilePath) extends ImageIOFileRgbImageLoader(filePath) {

}