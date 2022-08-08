package Character
import Character.CharacterRarity

object MyClass {
  def main(args: Array[String]) : Unit = {
    println("hello from the main method")
    println(CharacterRarity.EPIC.id)

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
      rarity = CharacterRarity.RARE,
      attribute = "", //Todo update later
      role = CharacterRole.FIGHTER)
      
    val inv : CharacterInventory = new CharacterInventory()

    val MC : BaseCharacter = new BaseCharacter(
      personalInfo = info,
      characterAttributes = attr,
      characterInventory = inv)

    MC.displayInfo()
  }
}
