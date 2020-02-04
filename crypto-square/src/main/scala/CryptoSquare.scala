object CryptoSquare {
  def normalizePlaintext(text: String): String = text.toLowerCase.filter(_.isLetterOrDigit)

  def squareSize(text: String): Int = Math.sqrt(normalizePlaintext(text).length).ceil.toInt

  def plaintextSegments(text: String): List[String] = normalizePlaintext(text) match {
      case "" => List.empty[String]
      case t => t.grouped(squareSize(text)).toList
    }

  def ciphertext(text: String): String = {
    cipher(plaintextSegments(text), List.empty[String]).mkString
  }

  def normalizedCiphertext(text: String): String = {
    cipher(plaintextSegments(text), List.empty[String]).mkString(" ")
  }

  lazy val cipher: (List[String], List[String]) => List[String] = {
    case (Nil, acc) =>
      acc

    case (segments, acc) =>
      cipher(
        segments.collect { case s if s.length > 1 => s.tail },
        acc :+ segments.map(_.head).mkString
      )
  }
}