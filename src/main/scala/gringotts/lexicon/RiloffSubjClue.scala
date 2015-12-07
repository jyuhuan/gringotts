package gringotts.lexicon

import gringotts.Inventory
import me.yuhuan.util.io.TextFile

/**
  * Riloff and Wiebe's Subjectivity Clues.
  *
  * Fixes:
  * Lines 5549 and 5550 have an extra "m" after "stemmed1=n". The "m" is deleted.
  *
  * @see [[https://www.cs.utah.edu/~riloff/pdfs/emnlp03.pdf]]
  *
  * @author Yuhuan Jiang (jyuhuan@gmail.com).
  */
object RiloffSubjClue {
  /**
    * (Word) => (PartOfSpeech => (Polarity, StrongOrWeak))
    */
  private val data: Map[String, Map[String, (String, String)]] = {
    val ts1 = TextFile.readLines(Inventory.RiloffSubjClue).map { l =>
      val kvPairStrings = l.split(' ')
      val word = kvPairStrings(2).split('=')(1)
      val partOfSpeech = kvPairStrings(3).split('=')(1)
      val polarity = kvPairStrings(5).split('=')(1)
      val strength = kvPairStrings(0).split('=')(1)
      (word, partOfSpeech, polarity, strength)
    }

    ts1.groupBy(_._1).map { case (word, ts2) =>
      word -> ts2.map { case (_, pos, pol, strength) =>
        pos -> (pol, strength)
      }.toMap
    }
  }

  /**
    * (Word, PartOfSpeech) => (Polarity, StrongOrWeak)
    */
  def apply(word: String, partOfSpeech: String): (String, String) = data(word)(partOfSpeech)

  /**
    * Word => (PartOfSpeech => (Polarity, StrongOrWeak))
    */
  def apply(word: String): Map[String, (String, String)] = data(word)

  def contains(word: String, partOfSpeech: String): Boolean = data.contains(word) && data(word).contains(partOfSpeech)
  def contains(word: String): Boolean = data contains word
}

object RiloffSubjClueTest extends App {

  val (polarity, strength) = RiloffSubjClue("abhor", "anypos")
  assert(polarity == "negative")
  assert(strength == "strongsubj")

  val asdfExists = RiloffSubjClue.contains("asdf")
  assert(!asdfExists)



  val bp = 0
}
