object HelloWorld {
  def hello(): String = hello("World")

  def hello(name: String): String = Option(name) match {
    case Some(n) if n.nonEmpty => s"Hello, $n!"
    case _ => hello()
  }
}
