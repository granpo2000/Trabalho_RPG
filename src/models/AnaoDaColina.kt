package models

import strategies.SubRaceStrategy

class AnaoDaColina : SubRaceStrategy {
    override fun getSubRaceName() = "Anão da Colina"

    override fun applySubRaceModifiers(atributos: MutableMap<String, Int>) {
        atributos["Sabedoria"] = atributos["Sabedoria"]!! + 1
    }
}
