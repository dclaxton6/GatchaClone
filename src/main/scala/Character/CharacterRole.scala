package Character

object CharacterRole extends Enumeration{
  type CharacterRole = Value
  val FIGHTER = Value(4,"Fighter")
  val DEFENDER = Value(3,"Defender")
  val SUPPORT = Value(2,"Support")
  val CONTROLLER = Value(1,"Controller")
}