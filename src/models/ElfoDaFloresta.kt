package models

import strategies.SubRaceStrategy

class ElfoDaFloresta : SubRaceStrategy {
    override fun getSubRaceName() = "Elfo da Floresta"

    override fun applySubRaceModifiers(atributos: MutableMap<String, Int>) {
        atributos["Sabedoria"] = atributos["Sabedoria"]!! + 1
    }
}
