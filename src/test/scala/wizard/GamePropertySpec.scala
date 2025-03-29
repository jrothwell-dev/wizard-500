//> using file Main.scala
//> using test.dep org.scalacheck::scalacheck:0.17.0
//> using test.dep org.scalameta::munit-scalacheck:1.1.0

package wizard.domain

import org.scalacheck.Prop._
import org.scalacheck.Gen

class GamePropertySpec extends munit.ScalaCheckSuite:
  property("Dealing should distribute correct number of cards"):
    forAll(Gen.chooseNum(1, 13)) { cardsPerPlayer =>
      val players = List(
        Player("0", "Alice", WizardClass.Pyromancer),
        Player("1", "Bob", WizardClass.Hydromancer),
        Player("2", "Charlie", WizardClass.Geomancer),
        Player("3", "Diana", WizardClass.Aeromancer)
      )

      val deck = Card.createWizardDeck()
      val round = Round(
        players = players,
        dealer = players.head,
        cardsPerPlayer = cardsPerPlayer,
        trump = None,
        deck = deck
      ).deal

      round.players.forall(_.hand.size == cardsPerPlayer)
    }
