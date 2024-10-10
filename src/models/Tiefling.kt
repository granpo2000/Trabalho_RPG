package models

import strategies.RaceStrategy

class Tiefling : RaceStrategy {
    override fun getRaceName() = "Tiefling"

    override fun applyRaceModifiers(atributos: MutableMap<String, Int>) {
        atributos["Inteligência"] = atributos["Inteligência"]!! + 1
        atributos["Carisma"] = atributos["Carisma"]!! + 2
    }
}
