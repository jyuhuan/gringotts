package gringotts

/**
  * @author Yuhuan Jiang (jyuhuan@gmail.com).
  */
object Inventory {
  val DeverbalNouns = this.getClass.getResourceAsStream("/list/deverbal-nouns/deverbal-nouns.txt")
  val ChoiConnotation = this.getClass.getResourceAsStream("/lexicon/choi-connotation/choi-connotation.csv")
  val RiloffSubjClue = this.getClass.getResourceAsStream("/lexicon/riloff-subjclue/riloff-subjclue.tff")
}
