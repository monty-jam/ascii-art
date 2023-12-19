package commands.exporters

import java.io.{File, FileOutputStream}

class FileOutputExporter(file: File) extends StreamTextExporter(new FileOutputStream(file)) {

}
