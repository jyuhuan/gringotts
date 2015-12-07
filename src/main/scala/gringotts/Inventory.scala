package gringotts

/**
  * @author Yuhuan Jiang (jyuhuan@gmail.com).
  */
object Inventory {
  val DeverbalNouns = this.getClass.getResourceAsStream("/list/deverbal-nouns.txt")
  val ChoiConnotation = this.getClass.getResourceAsStream("/lexicon/connotation/choi-connotation.csv")
}
