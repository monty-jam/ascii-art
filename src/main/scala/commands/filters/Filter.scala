package commands.filters

trait Filter[T] {
  def filter(source: T) : T
}
