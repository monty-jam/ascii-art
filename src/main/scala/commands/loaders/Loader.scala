package commands.loaders

trait Loader[T] {
  def load(): T
}
