import scala.language.postfixOps

object ETL {
  val transform: Map[Int, Seq[String]] => Map[String, Int] = _.flatMap {
    case (i, seq) => seq map { _.toLowerCase -> i }
  }
}