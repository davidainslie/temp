object PrimeFactors {
  def forNumber(n: Long): Seq[Long] = {
    def calc(number: Long, divisor: Long, factors: Seq[Long]): Seq[Long] = {
      if (divisor > number) {
        factors
      } else if (number % divisor == 0) {
        calc(number / divisor, divisor, factors :+ divisor)
      } else {
        calc(number, divisor + 1, factors)
      }
    }

    calc(n, 2, Seq.empty[Long])
  }
}