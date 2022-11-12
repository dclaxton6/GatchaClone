package Character

class CharacterStats() {

  case class stat(name:(String), value:(Int))

  var HP = 0
  var ATK = 0
  var DEF = 0
  var SPD = 0
  var CRIT = 0
  var CDAM = 0
  var ACC = 0
  var RES = 0
}

object CharacterStatNames extends Enumeration{
  type CharacterStatNames = Value
  val HP = Value("HP")
  val ATK = Value("ATK")
  val DEF = Value("DEF")
  val SPD = Value("SPD")
  val CRIT = Value("CRIT")
  val CDAM = Value("CDAM")
  val ACC = Value("ACC")
  val RES = Value("RES")
}

