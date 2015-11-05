package gringotts

import me.yuhuan.util.io._


/**
  * Deverbal nouns provided by NomBank.
  * @author Yuhuan Jiang (jyuhuan@gmail.com).
  */
object DeverbalNouns extends (String ⇒ Boolean) {
  private[gringotts] val deverbalNouns = TextFile.readLines(Inventory.DeverbalNouns).toSet
  def apply(word: String) = this contains word
  def contains(word: String) = deverbalNouns contains word
}
