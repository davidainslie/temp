import scala.math.BigDecimal

case class SpaceAge(seconds: Long) {
  private val earthYears: Double = seconds / 31557600D

  val round: Double => Double = { d =>
    BigDecimal(d).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
  }

  val onEarth: Double = round(earthYears)

  val onMercury: Double = round(earthYears / 0.2408467)

  val onVenus: Double = round(earthYears / 0.61519726)

  val onMars: Double = round(earthYears / 1.8808158)

  val onJupiter: Double = round(earthYears / 11.862615)

  val onSaturn: Double = round(earthYears / 29.447498)

  val onUranus: Double = round(earthYears / 84.016846)

  val onNeptune: Double = round(earthYears / 164.79132)
}