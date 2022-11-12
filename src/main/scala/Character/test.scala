package Character

import Character.CharacterRarity
import Character.CharacterAttributes
import Inventory.CharacterInventory
object MyClass {
  def main(args: Array[String]) : Unit = {

    val info : PersonalInfo = new PersonalInfo(
      name = "Testy",
      age = 23,
      height = 76,
      favorite = "games",
      affliation = "",//Todo update later
      relationships = "",//Todo update later
      origin = "",//Todo update later
      reference = ""//Todo update later
     )

    val attr : CharacterAttributes = new CharacterAttributes(
      rarity = CharacterRarity.EPIC,
      role = CharacterRole.FIGHTER,
      CharacterType.INFERNO
    )
      
    val inv : CharacterInventory = new CharacterInventory()

    val moveset: Seq[BaseMove]  = Seq(
      new BaseMove("Iron Fists", attr.Movetype, 0,0, Seq.empty),
      new BaseMove("Flames of Fury", attr.Movetype, 0,4, Seq.empty),
      new BaseMove("Rage Avatar", attr.Movetype, 3,4, Seq.empty)
    )

    val MC : BaseCharacter = new BaseCharacter(
      personalInfo = info,
      characterAttributes = attr,
      characterInventory = inv,
      moveset = moveset
    )

    MC.generateStats(info, attr)
    MC.displayInfo()
  }
}
