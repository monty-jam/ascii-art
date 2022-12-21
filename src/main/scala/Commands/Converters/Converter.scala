package Commands.Converters

trait Converter[T, O] {

  def convert(source: T) : O

}
