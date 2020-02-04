import scala.language.postfixOps
import scala.{Either => Or}

class DNA(nucleotides: String) {
  val validNucleotides = Set('A', 'C', 'G', 'T')

  val validateNeucleotides: Seq[Char] => (String Or Seq[Char]) = nucleotides =>
    nucleotides.toSet diff validNucleotides match {
      case ns if ns.nonEmpty => Left {
        s"invalid nucleotide ${ns.mkString("'", ", ", "'")}"
      }

      case _ => Right(nucleotides)
    }

  val count: Char => (String Or Int) = nucleotide => for {
    nucleotides <- validateNeucleotides(nucleotides.toCharArray).right
    _ <- validateNeucleotides(Seq(nucleotide)).right
  } yield
    nucleotides.count(_ == nucleotide)


  lazy val nucleotideCounts: String Or Map[Char, Int] = for {
    nucleotides <- validateNeucleotides(nucleotides.toCharArray).right
  } yield
    validNucleotides map { n => n -> nucleotides.count(_ == n) } toMap
}