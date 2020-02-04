import Allergen.Allergen

object Allergies {
  def isAllergicTo(allergen: Allergen, score: Int): Boolean = (allergen.id & score) != 0

  def allergies(score: Int): List[Allergen] = Allergen.values.toList filter { a => isAllergicTo(a, score) }
}

object Allergen extends Enumeration {
  type Allergen = Value

  val Eggs = Value(1)
  val Peanuts = Value(2)
  val Shellfish = Value(4)
  val Strawberries = Value(8)
  val Tomatoes = Value(16)
  val Chocolate = Value(32)
  val Pollen = Value(64)
  val Cats = Value(128)
}