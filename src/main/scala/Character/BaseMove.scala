package Character

class BaseMove (name:String, moveType:CharacterType.Value, attackCount: Int, cooldown: Int, targets:Seq[BaseCharacter]) {
val this.name = name
val this.moveType = moveType
val this.attackCount = attackCount
val this.cooldown = cooldown
val this.targets = targets


  override def toString: String = s"${name} / ${moveType}"
}
