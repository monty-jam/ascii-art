package commands.loaders.fileloaders

import commands.loaders.Loader
import models.filepaths.FilePath

import scala.annotation.meta.param

/**
 * Abstract class for loading files
 * @param filePath path to file
 * @tparam T the result of reading the file
 * @tparam O output Image class
 */
abstract class FileLoader[T, O] (val filePath: FilePath) extends Loader[O] {

  /**
   * Each file loader must implement file reading and specify the result of reading the file
   * Then this method is called inside load() method
   * @return the result of reading the file
   */
  protected def readFile(): T
}
