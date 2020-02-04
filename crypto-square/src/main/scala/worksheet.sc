def normalizePlaintext(s: String) = s.filter(_.isLetterOrDigit).toLowerCase

def squareSize(s: String) = Math.ceil(Math.sqrt(normalizePlaintext(s).length)).toInt

def plaintextSegments(s: String)  = (normalizePlaintext(s) grouped(squareSize(s))).toList

def ciphertext(s: String) = normalizedCiphertext(s).replace(" ", "")

def normalizedCiphertext(s: String) = {
  s.trim == "" match {
    case true  => ""
    case false => {
      plaintextSegments(s).map(_.padTo(squareSize(s), " "))
        .transpose.map(_.mkString).mkString(" ").replace("  ", " ").trim
    }
  }
}
