package me.yuhuan.gringotts.list

import me.yuhuan.gringotts._
import me.yuhuan.util.io._


/**
  * Deverbal nouns provided by NomBank.
 *
  * @see [[http://nlp.cs.nyu.edu/meyers/NomBank.html]]
  * @author Yuhuan Jiang (jyuhuan@gmail.com).
  */
object DeverbalNouns extends (String ⇒ Boolean) {
  private[gringotts] val deverbalNouns = TextFile.readLines(Inventory.List.DeverbalNouns).toSet
  def apply(word: String) = this contains word
  def contains(word: String) = deverbalNouns contains word
}

private object DeverbalNounsTest extends App {

  assert(DeverbalNouns contains "pollution")

}
