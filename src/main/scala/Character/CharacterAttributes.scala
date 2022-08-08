package Character

class CharacterAttributes (rarity: CharacterRarity.Value, attribute: String, role: CharacterRole.Value){

 val Rarity = rarity
  val Attribute = attribute
  val Role = role

  var Hp = 0
  var Atk = 0
  var Def = 0
  var Spd = 0


  /*
  * HP
  * Atk
  * Def
  * spd
  * Crit rate
  * crit damage
  * acc
  * resistance
  * */

  /*
*
* Fighter  Atk and Crit Rate / Lower Hp, Def, Spd
*
* Defender Def and Crit Damage or HP /
*
* Support Hp Def or Spd / Lower Atk
*
* Controller Mid Atk
*
* */
}


