package models

import strategies.RaceStrategy

class Anao : RaceStrategy {
    override fun getRaceName() = "Anão"

    override fun applyRaceModifiers(atributos: MutableMap<String, Int>) {
        atributos["Constituição"] = atributos["Constituição"]!! + 2
    }
}
