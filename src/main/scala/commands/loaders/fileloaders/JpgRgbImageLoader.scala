package commands.loaders.fileloaders

import models.PathFiles.JpgFilePath

class JpgRgbImageLoader(override val filePath: JpgFilePath) extends ImageIORgbImageLoader(filePath) {

}