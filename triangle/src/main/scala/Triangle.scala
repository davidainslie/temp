import TriangleType._

case class Triangle(x: Int, y: Int, z: Int) {
  val triangleType: TriangleType = typeOf(this)
}

object TriangleType {
  trait TriangleType

  object Equilateral extends TriangleType

  object Isosceles extends TriangleType

  object Scalene extends TriangleType

  object Illogical extends TriangleType

  val differentSides: Triangle => Int = { t =>
    Set(t.x, t.y, t.z).size
  }

  val typeOf: Triangle => TriangleType = {
    case t if t.x <= 0 || t.y <= 0 || t.z <= 0 => Illogical
    case t if (t.x + t.y < t.z) || (t.y + t.z < t.x) || (t.z + t.x < t.y) => Illogical
    case t if differentSides(t) == 1 => Equilateral
    case t if differentSides(t) == 2 => Isosceles
    case _ => Scalene
  }
}