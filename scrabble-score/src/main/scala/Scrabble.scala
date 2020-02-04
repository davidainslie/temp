class Scrabble {
  val scoreLetter: Char => Int = _.toUpper match {
    case 'A' | 'E' | 'I' | 'O' | 'U' | 'L' | 'N' | 'R' | 'S' | 'T' => 1
    case 'D' | 'G' => 2
    case 'B' | 'C' | 'M' | 'P' => 3
    case 'F' | 'H' | 'V' | 'W' | 'Y' => 4
    case 'K' => 5
    case 'J' | 'X' => 8
    case 'Q' | 'Z' => 10
  }

  val scoreWord: String => Int = _.map(scoreLetter).sum
}