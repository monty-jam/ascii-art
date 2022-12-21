package Commands.Filters

trait Filter[T] {
  def filter(source: T) : T
}
