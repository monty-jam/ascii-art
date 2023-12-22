package commands.loaders.fileloaders

import models.filepaths.PngFilePath

class PngRgbImageLoader(override val filePath: PngFilePath) extends ImageIOFileRgbImageLoader(filePath) {

}
