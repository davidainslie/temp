import Math.pow
import scala.language.postfixOps

object AllYourBase {
  val asDecimal: (Int, List[Int]) => Option[Int] = { (fromBase, digits) =>
    lazy val asDecimal: (Int, Int, List[Int]) => Option[Int] = {
      case (acc, _, Nil) => Some(acc)
      case (_, _, d +: _) if d < 0 || d >= fromBase => None
      case (acc, exponent, d +: ds) => asDecimal((acc + d * pow(fromBase, exponent)).toInt, exponent + 1, ds)
    }

    asDecimal(0, 0, digits.reverse)
  }

  val decimalToBase: (Int, Int) => List[Int] = { (decimal, base) =>
    lazy val decimalToBase: (List[Int], Int) => List[Int] = {
      case (acc, 0) =>
        acc

      case (acc, d) =>
        val quotient = d / base
        val remainder = d % base

        if (quotient >= 0) decimalToBase(remainder +: acc, quotient)
        else remainder +: acc
    }

    decimalToBase(List.empty[Int], decimal)
  }

  val rebase: (Int, List[Int], Int) => Option[List[Int]] = { (fromBase, fromDigits, toBase) =>
    if (fromBase <= 1 || toBase <= 1) None
    else asDecimal(fromBase, fromDigits) map { decimalToBase(_, toBase) }
  }
}