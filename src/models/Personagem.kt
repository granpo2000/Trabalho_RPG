package models

import strategies.ClassStrategy
import strategies.RaceStrategy
import strategies.SubRaceStrategy

data class Personagem(
    var nome: String,
    var raca: RaceStrategy,
    var subRaca: SubRaceStrategy? = null,
    var classePersonagem: ClassStrategy,
    var atributos: MutableMap<String, Int> = mutableMapOf(
        "Força" to 8,
        "Constituição" to 8,
        "Destreza" to 8,
        "Sabedoria" to 8,
        "Inteligência" to 8,
        "Carisma" to 8
    )
) {
    fun aplicarBonus() {
        raca.applyRaceModifiers(atributos)
        subRaca?.applySubRaceModifiers(atributos)
        classePersonagem.applyClassModifiers(atributos)
    }
}
