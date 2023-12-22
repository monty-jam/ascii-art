package commands.exporters

import org.scalatest.FunSuite

import java.io.{ByteArrayOutputStream, PrintStream}

class StdOutputExporterTests extends FunSuite {

  test("Exporting to StdOutput") {
    val originalOut = System.out
    val baos = new ByteArrayOutputStream()
    val ps = new PrintStream(baos)
    System.setOut(ps)

    val exporter = new StdOutputExporter

    exporter.export("Ahoj")

    System.out.flush()
    System.setOut(originalOut)

    val output = baos.toString
    assert(output.trim == "Ahoj")
  }

  test("Trying to write after closing the stream") {
    val exporter = new StdOutputExporter

    exporter.export("Ahoj")
    exporter.close()
    assertThrows[Exception](exporter.export("Ahoj"))
  }

}
