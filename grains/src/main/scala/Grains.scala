object Grains {
  /*val square: Int => Option[BigInt] = Option(_) collect {
    case x if x >= 0 && x <= 64 => BigInt(1) << x - 1
  }

  val total: BigInt = (1 to 64).flatMap(square(_)).sum*/

  private val SquaresCount = 64

  private val squareStream: BigInt => Stream[BigInt] = { x =>
    x #:: squareStream(x * 2)
  }

  private lazy val squareSeq = squareStream(1) take SquaresCount

  val square: Int => Option[BigInt] = Option(_).filter(x => x >= 0 && x <= 64).map(x => squareSeq(x - 1))

  lazy val total = (1 to SquaresCount).flatMap(square(_)).sum
}