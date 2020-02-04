class Phrase(text: String) {
  lazy val wordCount = {
    val toWords: String => Seq[String] = { text =>
      lazy val accumulate: (Seq[Char], String, Seq[String]) => Seq[String] = {
        case (Nil, word, words) =>
          if (word.isEmpty) words
          else words :+ word

        case (firstChar +: remainingChars, word, words) if firstChar.isLetterOrDigit || firstChar == '\'' =>
          accumulate(remainingChars, word + firstChar, words)

        case (firstChar +: remainingChars, word, words) =>
          if (word.isEmpty) accumulate(remainingChars, word, words)
          else accumulate(remainingChars, "", words :+ word)
      }

      accumulate(text.toLowerCase.toCharArray, "", Seq.empty[String])
    }

    toWords(text) groupBy identity mapValues(_.length)
  }
}