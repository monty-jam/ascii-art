package models.filepaths

import org.scalatest.FunSuite

class JpgFilePathTests extends FunSuite {
    test("Creating simple correct JpgFilePath") {
      val filePath = JpgFilePath("examples/blackWhite.jpg")
      assert(filePath.getFilePathValue == "examples/blackWhite.jpg")
    }

  test("Creating invalid JpgFilePath") {
    assertThrows[Exception](JpgFilePath("examples/blackWhite.png"))
  }
}
