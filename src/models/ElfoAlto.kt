package models

import strategies.SubRaceStrategy

class ElfoAlto : SubRaceStrategy {
    override fun getSubRaceName() = "Elfo Alto"

    override fun applySubRaceModifiers(atributos: MutableMap<String, Int>) {
        atributos["Inteligência"] = atributos["Inteligência"]!! + 1
    }
}
