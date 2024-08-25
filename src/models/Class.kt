package models

enum class ClassType {
    BARBARIAN, BARD, CLERIC, DRUID, FIGHTER, MONK, PALADIN, RANGER, ROGUE, SORCERER, WARLOCK, WIZARD
}

data class CharacterClass(
    val name: ClassType,
    val classAttributes: Map<String, Int>
) {
    companion object {
        fun getCharacterClass(name: ClassType): CharacterClass {
            return when (name) {
                ClassType.BARBARIAN -> CharacterClass(name, mapOf("Strength" to 2))
                ClassType.BARD -> CharacterClass(name, mapOf("Charisma" to 2))
                ClassType.CLERIC -> CharacterClass(name, mapOf("Wisdom" to 2))
                ClassType.DRUID -> CharacterClass(name, mapOf("Wisdom" to 2))
                ClassType.FIGHTER -> CharacterClass(name, mapOf("Strength" to 1, "Dexterity" to 1))
                ClassType.MONK -> CharacterClass(name, mapOf("Dexterity" to 2))
                ClassType.PALADIN -> CharacterClass(name, mapOf("Strength" to 2))
                ClassType.RANGER -> CharacterClass(name, mapOf("Dexterity" to 2))
                ClassType.ROGUE -> CharacterClass(name, mapOf("Dexterity" to 2))
                ClassType.SORCERER -> CharacterClass(name, mapOf("Charisma" to 2))
                ClassType.WARLOCK -> CharacterClass(name, mapOf("Charisma" to 2))
                ClassType.WIZARD -> CharacterClass(name, mapOf("Intelligence" to 2))
            }
        }
    }
}
