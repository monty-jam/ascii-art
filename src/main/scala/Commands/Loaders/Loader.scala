package Commands.Loaders

trait Loader[T] {
  def load(): T
}
