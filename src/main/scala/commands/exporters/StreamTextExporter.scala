package commands.exporters

import java.io.OutputStream

class StreamTextExporter(outputStream: OutputStream) extends TextExporter {
  private var closed = false

  private def exportToStream(text: String): Unit = {

    if (closed)
      throw new Exception("The stream is already closed")

    outputStream.write(text.getBytes("UTF-8"))
    outputStream.flush()
  }

  def close(): Unit = {
    if (closed)
      return

    outputStream.close()
    closed = true
  }

  override def export(item: String): Unit = exportToStream(item)

}
