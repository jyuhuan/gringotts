package gringotts.lexicon

import gringotts.Inventory
import me.yuhuan.util.io.TextFile

/**
  * @author Yuhuan Jiang (jyuhuan@gmail.com).
  */
object ChoiConnotation {
  private val data: Map[(String, String), String] = TextFile.readLines(Inventory.ChoiConnotation).map { l =>
    val parts = l.split(',')
    val wordAndPos = parts(0).split('_')
    val polarity = parts(1)
    val word = wordAndPos(0)
    val pos = wordAndPos(1)

    ((word, pos), polarity)
  }.toMap

  def apply(word: String, partOfSpeech: String): String = data(word, partOfSpeech)
  def contains(word: String, partOfSpeech: String): Boolean = data.contains((word, partOfSpeech))
  def contains(word: String): Boolean = data.exists(_._1._1 == word)
}

object ChoiConnotationTest extends App {
  val polarity = ChoiConnotation("stupid", "adjective")
  assert(polarity == "negative")

  val bp = 9
}
