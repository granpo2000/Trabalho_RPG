package models

data class Character(
    var name: String,
    var race: Race,
    var subRace: SubRace?,
    var characterClass: CharacterClass,
    var attributes: MutableMap<String, Int> = mutableMapOf(
        "Strength" to 3,
        "Constitution" to 3,
        "Dexterity" to 3,
        "Wisdom" to 3,
        "Intelligence" to 3,
        "Charisma" to 3
    )
) {
    fun applyBonuses() {
        race.baseAttributes.forEach { (key, value) -> attributes[key] = attributes[key]!! + value }

        subRace?.additionalAttributes?.forEach { (key, value) -> attributes[key] = attributes[key]!! + value }

        characterClass.classAttributes.forEach { (key, value) -> attributes[key] = attributes[key]!! + value }
    }
}
