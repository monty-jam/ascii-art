package models.filepaths

import org.scalatest.FunSuite

class FilePathTests extends FunSuite {
    test("Creating simple correct filePath") {
      val filePath = new FilePath("test")
      assert(filePath.getFilePathValue == "test")
    }
}
