import org.scalatest.{Matchers, FunSuite}

class scrabble_score_test extends FunSuite with Matchers {
  test("score letter 'a'") {
    new Scrabble().scoreLetter('a') should be (1)
  }

  test("score letter 'A'") {
    new Scrabble().scoreLetter('A') should be (1)
  }

  test("score letter 'b'") {
    new Scrabble().scoreLetter('b') should be (3)
  }

  test("score letter 'B'") {
    new Scrabble().scoreLetter('B') should be (3)
  }

  test("score letter 'q'") {
    new Scrabble().scoreLetter('q') should be (10)
  }

  test("score word") {
    new Scrabble().scoreWord("at") should be (2)
  }

  test("score word with dupe letters") {
    new Scrabble().scoreWord("street") should be (6)
  }

  test("score quirky word") {
    new Scrabble().scoreWord("quirky") should be (22)
  }

  test("score capitalized word") {
    new Scrabble().scoreWord("OXYPHENBUTAZONE") should be (41)
  }

  test("score mixed case word") {
    new Scrabble().scoreWord("Oxyphenbutazone") should be (41)
  }
}