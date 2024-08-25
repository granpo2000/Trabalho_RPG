package models

enum class RaceType {
    HUMAN, DWARF, ELF, HALFLING, GNOME, HALF_ELF, HALF_ORC, TIEFLING
}

data class Race(
    val name: RaceType,
    val baseAttributes: Map<String, Int>
) {
    companion object {
        fun getRace(name: RaceType): Race {
            return when (name) {
                RaceType.HUMAN -> Race(name, mapOf("Strength" to 1, "Constitution" to 1, "Dexterity" to 1, "Wisdom" to 1, "Intelligence" to 1, "Charisma" to 1))
                RaceType.DWARF -> Race(name, mapOf("Strength" to 0, "Constitution" to 2, "Dexterity" to 0, "Wisdom" to 1, "Intelligence" to 0, "Charisma" to 0))
                RaceType.ELF -> Race(name, mapOf("Strength" to 0, "Constitution" to 0, "Dexterity" to 2, "Wisdom" to 0, "Intelligence" to 0, "Charisma" to 0))
                RaceType.HALFLING -> Race(name, mapOf("Strength" to 0, "Constitution" to 0, "Dexterity" to 2, "Wisdom" to 0, "Intelligence" to 0, "Charisma" to 0))
                RaceType.GNOME -> Race(name, mapOf("Strength" to 0, "Constitution" to 0, "Dexterity" to 1, "Wisdom" to 0, "Intelligence" to 2, "Charisma" to 0))
                RaceType.HALF_ELF -> Race(name, mapOf("Strength" to 0, "Constitution" to 0, "Dexterity" to 0, "Wisdom" to 0, "Intelligence" to 0, "Charisma" to 2))
                RaceType.HALF_ORC -> Race(name, mapOf("Strength" to 2, "Constitution" to 1, "Dexterity" to 0, "Wisdom" to 0, "Intelligence" to 0, "Charisma" to 0))
                RaceType.TIEFLING -> Race(name, mapOf("Strength" to 0, "Constitution" to 0, "Dexterity" to 0, "Wisdom" to 0, "Intelligence" to 1, "Charisma" to 2))
            }
        }
    }
}
