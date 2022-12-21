package Commands.Exporters

trait Exporter[T] {
  def export(item: T): Unit
}
