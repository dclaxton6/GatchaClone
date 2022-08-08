package Character

import scala.util.Random

class BaseCharacter (
                      personalInfo: PersonalInfo,
                      characterAttributes: CharacterAttributes,
                      characterInventory: CharacterInventory
                    ) {

  val Info = personalInfo
  val Attr = characterAttributes
// Stat sheet that include the following:
/*
* -----Growth------
* Ascension Phase
*
*
*
*
* Relics
* (Buffs)
* (Careers, Diary, Album)
* Future Idea.. after battle system completed added next up text for order of enemy attack
*  Future Idea..  add battle reports after battle with damage dealt dmg taken protection and support
 Future Idea.. xp boost items i think it just functions like a rare candy in pokemon
* Base xp for each battle at a flat rate regardless of current level
*Need a leveling system( base level , xp, xp to next level
* */

  def generateStats(info: PersonalInfo, attr: CharacterAttributes) = {

    val minAtk = 753
    val maxAtk = 1332
    val minDef = 722
    val maxDef = 1243
    val minSpd = 90
    val maxSpd = 107
    val minHp = 9608
    val maxHp = 16680
    
    println("Atk: ")
    println("Attack Changed to: " + attr.Atk)
    println("Def: ")
    calcStatDif(maxDef, minDef, attr)
    println("Spd: ")
    calcStatDif(maxSpd, minSpd, attr)
    println("Hp: ")
    calcStatDif(maxHp, minHp, attr)

  }

 def calcDif(max:Int, min:Int): Double ={
   ((max-min).toDouble/4).ceil
 }

 def calcSubDif(dif: Double): Double ={
   (dif/3).ceil
 }

  def calcBoundary(min: Int, dif: Double, n: Int): Double = {
    min + ((n - 1) * dif)
  }

  def calcSubBoundary(bound: Double, dif:Double, n: Int): Seq[Double] = {
    val lower = bound + ((n - 1) * (dif - 1))
    val upper = lower + dif - 1
    Seq(lower, upper)
  }

 def calcStatDif(max: Int, min: Int, attr: CharacterAttributes): Unit ={

   println("Rarity: " + attr.Rarity + " " + attr.Rarity.id)
   println("Role: " + attr.Role + " " + attr.Role.id)

   val dif = calcDif(max, min)
   val bound = calcBoundary(min, dif, attr.Role.id)
   val subDif = calcSubDif(dif)
   val Boundaries = calcSubBoundary(bound, subDif, attr.Rarity.id)
   val randomNum = Random.between(Boundaries(0), Boundaries(1)).ceil
 }

  def displayInfo() = Console.println(
    "---------------Personal Info------------------\n"+
      s"            Name: ${personalInfo.Name}\n"+
      s"            Age: ${personalInfo.Age}\n"+
      s"            Height: ${personalInfo.Height}\n"+
      s"            Favorite: ${personalInfo.Favorite}\n"+
      s"            Affliation: ${personalInfo.Affliation}\n"+
      s"            Relationships: ${personalInfo.Relationships}\n"+
      s"            Origin: ${personalInfo.Origin}\n"+
      s"            Reference: ${personalInfo.Reference}\n"+

      "---------------Attributes--------------------\n"+
      s"            Rarity: ${Attr.Rarity}\n"+
      s"            Role: ${Attr.Role}\n"+
      s"            Attributes: ${Attr.Attribute}\n"+
      s"${generateStats(personalInfo, Attr)}"
  )
}
