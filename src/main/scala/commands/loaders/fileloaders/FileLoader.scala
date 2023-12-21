package commands.loaders.fileloaders

import commands.loaders.Loader
import models.FilePaths.FilePath

abstract class FileLoader[T, O] (val filePath: FilePath) extends Loader[O] {

  protected def readFile(): T
}
