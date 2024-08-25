package models

enum class SubRaceType {
    HILL_DWARF, MOUNTAIN_DWARF, HIGH_ELF, WOOD_ELF, DARK_ELF, LIGHTFOOT_HALFLING, STOUT_HALFLING, FOREST_GNOME, ROCK_GNOME
}

data class SubRace(
    val name: SubRaceType,
    val additionalAttributes: Map<String, Int>
) {
    companion object {
        fun getSubRace(name: SubRaceType): SubRace {
            return when (name) {
                SubRaceType.HILL_DWARF -> SubRace(name, mapOf("Wisdom" to 1, "Constitution" to 2))
                SubRaceType.MOUNTAIN_DWARF -> SubRace(name, mapOf("Strength" to 2, "Constitution" to 2))
                SubRaceType.HIGH_ELF -> SubRace(name, mapOf("Dexterity" to 2, "Intelligence" to 1))
                SubRaceType.WOOD_ELF -> SubRace(name, mapOf("Dexterity" to 2, "Wisdom" to 1))
                SubRaceType.DARK_ELF -> SubRace(name, mapOf("Dexterity" to 2, "Charisma" to 1))
                SubRaceType.LIGHTFOOT_HALFLING -> SubRace(name, mapOf("Dexterity" to 2, "Charisma" to 1))
                SubRaceType.STOUT_HALFLING -> SubRace(name, mapOf("Dexterity" to 2, "Constitution" to 1))
                SubRaceType.FOREST_GNOME -> SubRace(name, mapOf("Intelligence" to 2, "Dexterity" to 1))
                SubRaceType.ROCK_GNOME -> SubRace(name, mapOf("Intelligence" to 2, "Constitution" to 1))
            }
        }
    }
}
