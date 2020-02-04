import scala.annotation.tailrec

/*
object Sublist {
  def sublist[A](list1: Seq[A], list2: Seq[A]): Comparison = (list1, list2) match {
    case (l1, l2) if l1 == l2 => Equal
    case (l1, l2) if l2.containsSlice(l1) => Sublist
    case (l1, l2) if l1.containsSlice(l2) => Superlist
    case _ => Unequal
  }

  sealed trait Comparison

  object Equal extends Comparison

  object Unequal extends Comparison

  object Sublist extends Comparison

  object Superlist extends Comparison
}*/

object Sublist {
  def sublist[A](l1: List[A], l2: List[A]): Comparison = {
    @tailrec
    def check(l1: List[A], l2: List[A]): Boolean = {
      if (l1.size == l2.size) l1 == l2
      else if (l1.take(l2.size) == l2) true
      else check(l1.drop(1), l2)
    }

    if (l1 == l2) Equal
    else if (l1.length > l2.length && check(l1, l2)) Superlist
    else if (l1.length < l2.length && check(l2, l1)) Sublist
    else Unequal
  }

  sealed trait Comparison

  object Equal extends Comparison

  object Unequal extends Comparison

  object Sublist extends Comparison

  object Superlist extends Comparison
}
