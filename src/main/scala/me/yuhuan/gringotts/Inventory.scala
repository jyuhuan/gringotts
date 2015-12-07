package me.yuhuan.gringotts

/**
  * @author Yuhuan Jiang (jyuhuan@gmail.com).
  */
object Inventory {

  object Lexicon {
    val ChoiConnotation = this.getClass.getResourceAsStream("/lexicon/choi-connotation/choi-connotation.csv")
    val RiloffSubjClue = this.getClass.getResourceAsStream("/lexicon/riloff-subjclue/riloff-subjclue.tff")
    val GeneralInquireGfbf = this.getClass.getResourceAsStream("/lexicon/general-inquire/general-inquire-gfbf.txt")
  }

  object List {
    val DeverbalNouns = this.getClass.getResourceAsStream("/list/deverbal-nouns/deverbal-nouns.txt")
  }

}
