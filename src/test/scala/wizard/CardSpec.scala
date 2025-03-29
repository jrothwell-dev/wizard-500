//> using file "../../Main.scala"
//> using test.dep org.scalameta::munit:1.1.0

package wizard.domain

class CardSpec extends munit.FunSuite:
  test("Standard deck should have 52 cards"):
    val deck = Card.createStandardDeck()
    assertEquals(deck.size, 52)

  test("Wizard deck should have correct number of cards"):
    val deck = Card.createWizardDeck(wizardCount = 4, jesterCount = 4)
    assertEquals(deck.size, 60) // 52 standard + 4 wizards + 4 jesters

  test("Cards should have correct point values"):
    assertEquals(StandardCard(Suit.Hearts, Rank.Five).points, 5)
    assertEquals(StandardCard(Suit.Clubs, Rank.Ten).points, 10)
    assertEquals(StandardCard(Suit.Spades, Rank.King).points, 10)
    assertEquals(StandardCard(Suit.Diamonds, Rank.Ace).points, 15)
    assertEquals(StandardCard(Suit.Hearts, Rank.Two).points, 0)
    assertEquals(WizardCard().points, 25)
    assertEquals(JesterCard().points, 0)
