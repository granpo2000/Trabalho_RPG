package models

import strategies.RaceStrategy

class Elfo : RaceStrategy {
    override fun getRaceName() = "Elfo"

    override fun applyRaceModifiers(atributos: MutableMap<String, Int>) {
        atributos["Destreza"] = atributos["Destreza"]!! + 2
    }
}
