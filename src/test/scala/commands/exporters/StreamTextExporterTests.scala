package commands.exporters

import org.scalatest.FunSuite

import java.io.ByteArrayOutputStream

class StreamTextExporterTests extends FunSuite {

  test("Exporting to stream") {
    val stream = new ByteArrayOutputStream()
    val exporter = new StreamTextExporter(stream)

    exporter.export("Ahoj")

    assert(stream.toString("UTF-8") == "Ahoj")
  }

  test("Trying to write after closing the stream") {
    val stream = new ByteArrayOutputStream()
    val exporter = new StreamTextExporter(stream)

    exporter.export("Ahoj")
    exporter.close()
    assertThrows[Exception](exporter.export("Ahoj"))
  }

}
