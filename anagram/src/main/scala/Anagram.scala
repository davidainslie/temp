class Anagram(word: String) {
  val matches: Seq[String] => Seq[String] = { words =>
    val wordLowerCase = word.toLowerCase

    val isAnagram = (possibility: String) => {
      val possibilityLowerCase = possibility.toLowerCase

      possibilityLowerCase.sorted == wordLowerCase.sorted && possibilityLowerCase != wordLowerCase
    }

    words filter isAnagram
  }
}
