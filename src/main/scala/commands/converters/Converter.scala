package commands.converters

trait Converter[T, O] {

  def convert(source: T) : O

}
