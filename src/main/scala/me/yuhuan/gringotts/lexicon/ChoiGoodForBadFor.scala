package me.yuhuan.gringotts.lexicon

import me.yuhuan.gringotts.Inventory
import me.yuhuan.util.io.TextFile

/**
  * GoodFor and BadFor collected by Yoonjung Choi.
  * @author Yuhuan Jiang (jyuhuan@gmail.com).
  */
object ChoiGoodForBadFor {
  private val data: Map[String, Map[String, String]] = {
    val goodFors = TextFile.readLines(Inventory.Lexicon.ChoiGoodForBadFor.GoodFor).map { l =>
      val parts = l.split(',').map(_.tail.init)
      val word = parts(0)
      val pos = parts(1)
      //val frameNetId = parts(2)
      (word, pos, "goodFor")
    }

    val badFors = TextFile.readLines(Inventory.Lexicon.ChoiGoodForBadFor.BadFor).map { l =>
      val parts = l.split(',')
      val word = parts(0)
      val pos = parts(1)
      //val frameNetId = parts(2)
      (word, pos, "badFor")
    }

    (goodFors ++ badFors).groupBy(_._1).map { case (word, ts2) =>
      word -> ts2.map { case (_, pos, pol) =>
        pos -> pol
      }.toMap
    }
  }

  /**
    * Word => (PartOfSpeech => Polarity)
    * Possible POS tags are:
    * <ul>
    *   <li>a</li>
    *   <li>v</li>
    *   <li>n</li>
    *   <li>adv</li>
    * </ul>
    */
  def apply(word: String, partOfSpeech: String): String = data(word)(partOfSpeech)
  def apply(word: String): Map[String, String] = data(word)

  def contains(word: String, partOfSpeech: String): Boolean = data.contains(word) && data(word).contains(partOfSpeech)
  def contains(word: String): Boolean = data contains word

  def ?(word: String, partOfSpeech: String): Option[String] = {
    if (contains(word, partOfSpeech)) Some(apply(word, partOfSpeech)) else None
  }

  def ?(word: String): Option[Map[String, String]] = {
    if (contains(word)) Some(apply(word)) else None
  }

}

private object ChoiGoodForBadForTest extends App {


  val result = ChoiGoodForBadFor("pity")("v")
  assert(result == "goodFor")

  val bp = 0
}
