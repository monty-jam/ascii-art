package commands.exporters

import org.scalatest.FunSuite

import java.io.File
import scala.io.Source

class FileOutputExporterTests extends FunSuite {
  test("Exporting to File") {
    val exporter = new FileOutputExporter(new File("examples/output.txt"))

    exporter.export("Ahoj")

    val result = Source.fromFile("examples/output.txt").mkString
    Source.fromFile("examples/output.txt").close()

    assert(result == "Ahoj")
  }

  test("Exporting to non-existent path") {
    assertThrows[Exception](new FileOutputExporter(new File("examples/non-existent/output.txt")))
  }
}
