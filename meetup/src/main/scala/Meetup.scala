import java.util.{Calendar, GregorianCalendar}

object Meetup extends Enumeration {
  val Mon, Tue, Wed, Thu, Fri, Sat, Sun = Value

  val dayIndex: Calendar => Int = date => {
    val calendarDaysOfWeek = Seq(2, 3, 4, 5, 6, 7, 1)

    calendarDaysOfWeek indexOf date.get(Calendar.DAY_OF_WEEK)
  }
}

case class Meetup(month: Int, year: Int) {
  val teenth: Meetup.Value => Calendar = { meetup =>
    meetupDate(meetup)(13)
  }

  val first: Meetup.Value => Calendar = { meetup =>
    meetupDate(meetup)(1)
  }

  val second: Meetup.Value => Calendar = { meetup =>
    meetupDate(meetup)(8)
  }

  val third: Meetup.Value => Calendar = { meetup =>
    meetupDate(meetup)(15)
  }

  val fourth: Meetup.Value => Calendar = { meetup =>
    meetupDate(meetup)(22)
  }

  val last: Meetup.Value => Calendar = { meetup =>
    val startDay = new GregorianCalendar(year, month - 1, 1) getActualMaximum Calendar.DAY_OF_MONTH

    meetupDate(meetup, nextDay = _ - 1)(startDay)
  }

  def meetupDate(meetup: Meetup.Value, nextDay: Int => Int = _ + 1): Int => Calendar = {
    lazy val meetupDate: Int => Calendar = { day =>
      val date = new GregorianCalendar(year, month - 1, day)

      if (Meetup.dayIndex(date) == meetup.id) date
      else meetupDate(nextDay(day))
    }

    meetupDate
  }
}