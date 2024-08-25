import models.*
import utils.InputUtils

fun main() {
    println("Welcome to the RPG Character Creator!")

    val name = InputUtils.promptUser("Enter the name of your character")

    val raceOptions = RaceType.values().joinToString { it.name }
    val raceChoice = InputUtils.promptUser("Choose a race from the following options: $raceOptions").uppercase()
    val race = Race.getRace(RaceType.valueOf(raceChoice))

    val subRace: SubRace? = when (race.name) {
        RaceType.DWARF -> {
            val subRaceOptions = listOf(SubRaceType.HILL_DWARF.name, SubRaceType.MOUNTAIN_DWARF.name).joinToString()
            val subRaceChoice = InputUtils.promptUser("Choose a sub-race from the following options: $subRaceOptions").uppercase()
            SubRace.getSubRace(SubRaceType.valueOf(subRaceChoice))
        }
        RaceType.ELF -> {
            val subRaceOptions = listOf(SubRaceType.HIGH_ELF.name, SubRaceType.WOOD_ELF.name, SubRaceType.DARK_ELF.name).joinToString()
            val subRaceChoice = InputUtils.promptUser("Choose a sub-race from the following options: $subRaceOptions").uppercase()
            SubRace.getSubRace(SubRaceType.valueOf(subRaceChoice))
        }
        RaceType.HALFLING -> {
            val subRaceOptions = listOf(SubRaceType.LIGHTFOOT_HALFLING.name, SubRaceType.STOUT_HALFLING.name).joinToString()
            val subRaceChoice = InputUtils.promptUser("Choose a sub-race from the following options: $subRaceOptions").uppercase()
            SubRace.getSubRace(SubRaceType.valueOf(subRaceChoice))
        }
        RaceType.GNOME -> {
            val subRaceOptions = listOf(SubRaceType.FOREST_GNOME.name, SubRaceType.ROCK_GNOME.name).joinToString()
            val subRaceChoice = InputUtils.promptUser("Choose a sub-race from the following options: $subRaceOptions").uppercase()
            SubRace.getSubRace(SubRaceType.valueOf(subRaceChoice))
        }
        else -> null
    }

    val classOptions = ClassType.values().joinToString { it.name }
    val classChoice = InputUtils.promptUser("Choose a class from the following options: $classOptions").uppercase()
    val characterClass = CharacterClass.getCharacterClass(ClassType.valueOf(classChoice))

    val character = Character(name, race, subRace, characterClass)
    character.applyBonuses()

    println("You have 6 points to distribute among your attributes.")
    var pointsLeft = 6
    while (pointsLeft > 0) {
        println("Current attributes: ${character.attributes}")
        val attributeChoice = InputUtils.promptUser("Which attribute would you like to increase? (Strength, Constitution, Dexterity, Wisdom, Intelligence, Charisma)").capitalize()
        if (character.attributes.containsKey(attributeChoice)) {
            val pointsToAdd = InputUtils.promptUserForInt("How many points would you like to add? (Points left: $pointsLeft)")
            if (pointsToAdd in 1..pointsLeft) {
                character.attributes[attributeChoice] = character.attributes[attributeChoice]!! + pointsToAdd
                pointsLeft -= pointsToAdd
            } else {
                println("Invalid number of points.")
            }
        } else {
            println("Invalid attribute choice.")
        }
    }

    val description = InputUtils.promptUser("Enter a description of your character")

    println("\nCharacter Creation Complete! Here are your character's details:")
    println("Name: ${character.name}")
    println("Race: ${character.race.name}")
    subRace?.let { println("Sub-Race: ${it.name}") }
    println("Class: ${character.characterClass.name}")
    println("Attributes: ${character.attributes}")
    println("Description: $description")
}
