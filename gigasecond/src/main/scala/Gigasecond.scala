import java.time.{LocalDate, LocalDateTime}

object Gigasecond {
  val gigasecond = 1000000000

  def addGigaseconds(date: LocalDate): LocalDateTime = addGigaseconds(date.atStartOfDay())

  def addGigaseconds(dateTime: LocalDateTime): LocalDateTime = dateTime plusSeconds gigasecond
}