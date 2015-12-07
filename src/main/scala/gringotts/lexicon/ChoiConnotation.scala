package gringotts.lexicon

import gringotts.Inventory
import me.yuhuan.util.io.TextFile

/**
  * Yejin Choi's Connotation Lexicon.
  * @see [[http://www3.cs.stonybrook.edu/~ychoi/connotation/]].
  * @author Yuhuan Jiang (jyuhuan@gmail.com).
  */
object ChoiConnotation {
  private val data: Map[String, Map[String, String]] = {
    val ts1 = TextFile.readLines(Inventory.ChoiConnotation).map { l =>
      val parts = l.split(',')
      val wordAndPos = parts(0).split('_')
      val polarity = parts(1)
      val word = wordAndPos(0)
      val pos = wordAndPos(1)

      (word, pos, polarity)
    }

    ts1.groupBy(_._1).map { case (word, ts2) =>
      word -> ts2.map { case (_, pos, pol) =>
        pos -> pol
      }.toMap
    }
  }

  /**
    * Word => (PartOfSpeech => Polarity)
    */
  def apply(word: String, partOfSpeech: String): String = data(word)(partOfSpeech)
  def apply(word: String): Map[String, String] = data(word)

  def contains(word: String, partOfSpeech: String): Boolean = data.contains(word) && data(word).contains(partOfSpeech)
  def contains(word: String): Boolean = data contains word
}

object ChoiConnotationTest extends App {
  val polarity = ChoiConnotation("stupid", "adjective")
  assert(polarity == "negative")

  val bp = 9
}
