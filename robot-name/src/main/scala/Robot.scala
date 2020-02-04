import scala.language.postfixOps
import scala.util.Random
import Robot._

// Vars! Yuck! But that's the required API for you!
class Robot(private var _name: String = randomName) {
  def name: String = _name

  def reset() = _name = resetName(_name)
}

object Robot {
  private var names = Set.empty[String]

  def randomName: String = {
    val randomChars: (Int, Seq[Char]) => Seq[Char] = (size, range) =>
      Seq.fill(size) { range(Random nextInt range.size) }

    val name = (randomChars(2, 'A' to 'Z') ++ randomChars(3, '0' to '9')) mkString

    if (names(name)) {
      randomName
    } else {
      names += name
      name
    }
  }

  def resetName(name: String) = {
    names -= name
    randomName
  }
}