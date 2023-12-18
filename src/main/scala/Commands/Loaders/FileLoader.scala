package Commands.Loaders

import Models.PathFiles.FilePath

abstract class FileLoader[T, O] (val filePath: FilePath) extends Loader[O] {

  protected def readFile(): T
}
