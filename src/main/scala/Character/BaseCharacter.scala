package Character

import Character.CharacterStatNames.CharacterStatNames
import Inventory.CharacterInventory

import scala.util.Random

class BaseCharacter (personalInfo: PersonalInfo, characterAttributes: CharacterAttributes, 
                      characterInventory: CharacterInventory, moveset: Seq[BaseMove]) {

  val Info = personalInfo
  val Attr = characterAttributes
  val Moves = moveset
// Stat sheet that include the following:
/*
* -----Growth------
* Ascension Phase
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

    attr.Attribute.DEF = calcStatDif(CharacterStatNames.DEF, maxDef, minDef, attr)
    attr.Attribute.SPD = calcStatDif(CharacterStatNames.SPD, maxSpd, minSpd, attr)
    attr.Attribute.HP = calcStatDif(CharacterStatNames.HP, maxHp, minHp, attr)
    attr.Attribute.ATK = calcStatDif(CharacterStatNames.ATK, maxAtk, minAtk, attr)
    calcStatValueForRole(attr.Role, CharacterStatNames.ATK)
  }

 def calcDif(max:Int, min:Int): Double = {
   ((max-min).toDouble/4).ceil
 }

 def calcSubDif(dif: Double): Double = {
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


  //Todo finish calcStatValueForRole to get 1-4 num return then replace value
  def calcStatValueForRole(role: CharacterRole.Value, stat: CharacterStatNames): Int ={
    stat match {
      case CharacterStatNames.HP =>
        role match {
          case CharacterRole.FIGHTER => 2
          case CharacterRole.DEFENDER => 3
          case CharacterRole.CONTROLLER => 1
          case CharacterRole.SUPPORT => 4
        }
      case CharacterStatNames.ATK =>
        role match {
          case CharacterRole.FIGHTER => 4
          case CharacterRole.DEFENDER => 3
          case CharacterRole.CONTROLLER => 2
          case CharacterRole.SUPPORT => 1
        }
      case CharacterStatNames.DEF =>
        role match {
          case CharacterRole.FIGHTER => 1
          case CharacterRole.DEFENDER => 4
          case CharacterRole.CONTROLLER => 3
          case CharacterRole.SUPPORT => 2
        }
      case CharacterStatNames.SPD =>
        role match {
          case CharacterRole.FIGHTER => 2
          case CharacterRole.DEFENDER => 1
          case CharacterRole.CONTROLLER => 4
          case CharacterRole.SUPPORT => 3
        }
      case _ => 0
    }
  }

 def calcStatDif(statName: CharacterStatNames, max: Int, min: Int, attr: CharacterAttributes): Int ={

   val dif = calcDif(max, min)
   val bound = calcBoundary(min, dif, calcStatValueForRole(attr.Role, statName))
   val subDif = calcSubDif(dif)
   val Boundaries = calcSubBoundary(bound, subDif, attr.Rarity.id)
   val randomNum = Random.between(Boundaries(0), Boundaries(1)).ceil
   randomNum.toInt
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
      s"            Type: ${Attr.Movetype}\n"+
      s"            Stats|" +
      s" HP: ${Attr.Attribute.HP}" +
      s" ATK: ${Attr.Attribute.ATK}" +
      s" DEF: ${Attr.Attribute.DEF}" +
      s" SPD: ${Attr.Attribute.SPD}\n" +

      s"-----------------Moves-----------------------\n" +
      s" Move 1: ${Moves(0).toString()}\n" +
      s" Move 2: ${Moves(1).toString()}\n" +
      s" Move 3: ${Moves(2).toString()}\n" +
      s"\n"
  )
}
