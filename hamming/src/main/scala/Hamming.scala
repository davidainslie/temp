object Hamming {
  val sameLength = (dna1: String, dna2: String) => dna1.length == dna2.length

  val different: ((Char, Char)) => Boolean = {
    case (d1, d2) => d1 != d2
  }

  val compute: (String, String) => Option[Int] = {
    case (dna1, dna2) if sameLength(dna1, dna2) => Some(dna1 zip dna2 count different)
    case _ => None
  }
}