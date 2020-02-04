object Pangrams {
  val isPangram = (sentence: String) => ('a' to 'z').forall(sentence.toLowerCase.contains(_))
}
