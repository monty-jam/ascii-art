package commands.converters

/**
 * Abstract class for converting objects
 * @tparam T input object
 * @tparam O output object
 */
trait Converter[T, O] {

  def convert(source: T) : O

}
