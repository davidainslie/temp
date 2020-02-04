import scala.annotation.tailrec

case class RomanNumeral(decimal: Int) {
  val factors = Seq(1000 -> "M", 900 -> "CM", 500 -> "D", 400 -> "CD", 100 -> "C", 90 -> "XC", 50 -> "L", 40 -> "XL", 10 -> "X", 9 -> "IX", 5 -> "V", 4 -> "IV", 1 -> "I")

  val value = {
    @tailrec
    def numerate(decimal: Int, factors: Seq[(Int, String)], numeral: String): String = factors match {
      case Nil => numeral
      case (d, n) +: t => numerate(decimal % d, t, numeral + (n * (decimal / d)))
    }

    numerate(decimal, factors, "")
  }
}