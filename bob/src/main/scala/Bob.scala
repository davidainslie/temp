class Bob {
  type Conversation = PartialFunction[String, String]

  val hey: Conversation = {
    case s if s == null || s.trim.isEmpty => "Fine. Be that way!"

    case s if s.exists(_.isLetter) && s == s.toUpperCase => "Whoa, chill out!"

    case s if s.endsWith("?") => "Sure."

    case s => "Whatever."
  }
}
