package me.yuhuan.gringotts.lexicon

import me.yuhuan.gringotts.Inventory
import me.yuhuan.util.io.TextFile

/**
  * General Inquire (with only words that appear in GFBF corpus).
  * @author Yuhuan Jiang (jyuhuan@gmail.com).
  */
object GeneralInquireGfbf {
  private val data: Map[String, String] = TextFile.readLines(Inventory.Lexicon.GeneralInquireGfbf).map { l =>
    val parts = l.split(',')
    val word = parts(0)
    val polarity = parts(1)

    word -> polarity
  }.toMap

  def apply(word: String): String = data(word)
  def contains(word: String): Boolean = data contains word

  def ?(word: String): Option[String] = if (contains(word)) Some(apply(word)) else None
}

private object GeneralInquireGfbfTest extends App {

  assert(GeneralInquireGfbf contains "bright")
  assert(!(GeneralInquireGfbf contains "sun"))

  val polarity = GeneralInquireGfbf("bright")
  assert(polarity == "positive")


  val bp = 0
}
