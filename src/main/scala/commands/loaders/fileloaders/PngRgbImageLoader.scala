package commands.loaders.fileloaders

import models.PathFiles.PngFilePath

class PngRgbImageLoader(override val filePath: PngFilePath) extends ImageIORgbImageLoader(filePath) {

}
