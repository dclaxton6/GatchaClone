package Character

class CharacterAttributes (rarity: CharacterRarity.Value, role: CharacterRole.Value, ctype: CharacterType.Value){

 val Rarity = rarity
 val Attribute = new CharacterStats()
 val Role = role
 val Movetype = ctype
 
 
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


