import scala.annotation.tailrec
import scala.collection.generic.CanBuildFrom

class Accumulate {
  def accumulate[A, B](f: A => B, as: Seq[A])(implicit cbf: CanBuildFrom[Seq[A], B, Seq[B]]): Seq[B] = {
    @tailrec
    def accumulate(sa: Seq[A], sb: Seq[B]): Seq[B] = {
      if (sa.isEmpty) sb
      else accumulate(sa.tail, sb :+ f(sa.head))
    }

    accumulate(as, cbf(as).result())
  }
}