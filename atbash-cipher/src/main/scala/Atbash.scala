object Atbash {
  val alphabet = 'a' to 'z'
  val cipher = alphabet.zip(alphabet.reverse).toMap.withDefault(c => c)

  val removePunctuation: String => String = _.filter(_.isLetterOrDigit)

  def encode(s: String): String =
    removePunctuation(s.toLowerCase).map(cipher).grouped(5).mkString(" ")
}
