object Dna {
  val dna2rna = Map('G' -> 'C', 'C' -> 'G', 'T' -> 'A', 'A' -> 'U')

  val toRna: String => Option[String] = { dna =>
    lazy val toRna: (Seq[Char], Seq[Char]) => Option[String] = {
      case (Nil, rnas) => Some(rnas.mkString)
      case (c +: cs, rnas) => dna2rna get c flatMap { c => toRna(cs, rnas :+ c) }
    }

    toRna(dna.toSeq, Seq.empty[Char])
  }
}