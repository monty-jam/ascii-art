package Commands.Loaders

import Models.PathFiles.PngFilePath

class PngRgbImageLoader(override val filePath: PngFilePath) extends ImageIORgbImageLoader(filePath) {

}
