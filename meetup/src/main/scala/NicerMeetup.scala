object NicerMeetup {
  import java.util.{Calendar, GregorianCalendar}

  case class Meetup(month: Int, year: Int) {
    def teenth(day: Int): GregorianCalendar = filterWeek(day, 13 to 19)

    def first(day: Int): GregorianCalendar = filterWeek(day, 1 to 7)

    def second(day: Int): GregorianCalendar = filterWeek(day, 8 to 14)

    def third(day: Int): GregorianCalendar = filterWeek(day, 15 to 21)

    def fourth(day: Int): GregorianCalendar = filterWeek(day, 22 to 28)

    def last(day: Int): GregorianCalendar = filterWeek(day,
      Meetup lastDayOfMonth(year, month) to 22 by -1)

    def filterWeek(day: Int, range: Range): GregorianCalendar = range map
      (new GregorianCalendar(year, month - 1, _)) find
      (_.get(Calendar.DAY_OF_WEEK) == day) getOrElse(throw new Exception)
  }

  object Meetup {
    val Mon: Int = 2
    val Tue: Int = 3
    val Wed: Int = 4
    val Thu: Int = 5
    val Fri: Int = 6
    val Sat: Int = 7
    val Sun: Int = 1

    def lastDayOfMonth(year: Int, month: Int): Int = {
      new GregorianCalendar(year, month - 1, 1) getActualMaximum Calendar.DAY_OF_MONTH
    }
  }
}