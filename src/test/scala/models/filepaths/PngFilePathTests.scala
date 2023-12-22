package models.filepaths

import org.scalatest.FunSuite

class PngFilePathTests extends FunSuite {
    test("Creating simple correct PngFilePath") {
      val filePath = PngFilePath("examples/blackWhite.png")
      assert(filePath.getFilePathValue == "examples/blackWhite.png")
    }

  test("Creating invalid PngFilePath") {
    assertThrows[Exception](PngFilePath("examples/blackWhite.jpg"))
  }
}
