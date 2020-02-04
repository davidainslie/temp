import scala.language.postfixOps

object Squares {
  val square: Int => Int = { n =>
    n * n
  }

  val squareOfSums: Int => Int = { n =>
    square(1 to n sum)
  }

  val sumOfSquares: Int => Int = { n =>
    1 to n map square sum
  }

  val difference: Int => Int = { n =>
    squareOfSums(n) - sumOfSquares(n)
  }
}