package Commands.Loaders

import Models.PathFiles.JpgFilePath

class JpgRgbImageLoader(override val filePath: JpgFilePath) extends ImageIORgbImageLoader(filePath) {

}