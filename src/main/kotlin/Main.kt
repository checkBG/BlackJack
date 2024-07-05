import kotlin.random.Random
import kotlin.random.nextInt

fun main() {
    val player = Player()
    val dealer = Dealer()


    do {
    } while (player.costOfHand <= 21 && dealer.costOfHand <= 21)
}

abstract class PlayerBlackJack {
    abstract var costOfHand: Int
    protected abstract val cardsInHand: MutableList<String>
    protected abstract var numberOfAces: Int

    private val cards: MutableList<Pair<Rank, Suit>> = mutableListOf()

    init {
        Suit.entries.shuffled().forEach { suit ->
            Rank.entries.shuffled().forEach { rank ->
                cards += rank to suit
            }
        }
    }

    fun takeCard() {
        val tookCard = cards.shuffled().first()
        val typeOfCard = tookCard.first
        val suitOfCard = tookCard.second

        costOfHand += typeOfCard.cost
        cardsInHand += "${typeOfCard.name.lowercase().capitalize()} ${suitOfCard.name.lowercase().capitalize()}"
        cards -= Pair(typeOfCard, suitOfCard)

        if (typeOfCard == Rank.ACE) {
            numberOfAces++
        }

        recalculateOfAces()
    }

    private fun recalculateOfAces() {
        while (costOfHand > 21 && numberOfAces > 0) {
            costOfHand -= 10
            numberOfAces--
        }
    }
}

class Player : PlayerBlackJack() {
    override var costOfHand: Int = 0
    override val cardsInHand: MutableList<String> = mutableListOf()
    override var numberOfAces: Int = 0
}

class Dealer : PlayerBlackJack() {
    override var costOfHand: Int = 0
    override val cardsInHand: MutableList<String> = mutableListOf()
    override var numberOfAces: Int = 0

    private fun dealerAI(): String {
        println("The dealer starts taking cards")
        val redColor = "\u001b[31m"
        val blueColor =
            "\u001B[34m" // это для дальнейших обновлений, когда мы сможем выводить карту цветом, соответствующим её масти
        val greenColor = "\u001B[32m"
        val resetColor = "\u001b[0m"

        val finish: String by lazy {
            """
            |The dealer has finished taking the cards,
            |the value of his hands is $greenColor$costOfHand$resetColor,
            |his cards are "$redColor${cardsInHand.joinToString(", ")}$resetColor"
        """.trimMargin()
        }

        while (true) {
            when (costOfHand) {
                in 0..15 -> takeCard()

                in 16..17 -> {
                    when (Random.nextInt(1..10)) {
                        in 1..2 -> takeCard()
                        else -> return finish
                    }
                }

                in 18..19 -> {
                    when (Random.nextInt(1..10)) {
                        1 -> takeCard()
                        else -> return finish
                    }
                }

                20 -> {
                    when (Random.nextInt(1..100)) {
                        in 1..4 -> takeCard()
                        else -> return finish
                    }
                }

                21 -> return "$finish. \nCareful, the dealer got twenty-one points"

                else -> return "$finish.\nTake as many cards as you want, the dealer has too much"
            }
        }
    }

    init {
        println(dealerAI())
    }
}

enum class Suit { CLUBS, DIAMONDS, HEARTS, SPADES }
enum class Rank(val cost: Int) {
    ACE(11),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10)
}