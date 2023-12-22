package commands.loaders.fileloaders

import models.filepaths.JpgFilePath

class JpgRgbImageLoader(override val filePath: JpgFilePath) extends ImageIOFileRgbImageLoader(filePath) {

}