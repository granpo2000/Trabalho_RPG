package models

enum class TipoRaca {
    HUMANO, ANAO, ELFO, HALFLING, GNOMO, MEIO_ELFO, MEIO_ORC, TIEFLING
}

data class Raca(
    val nome: TipoRaca,
    val atributosBase: Map<String, Int>
) {
    companion object {
        fun obterRaca(nome: TipoRaca): Raca {
            return when (nome) {
                TipoRaca.HUMANO -> Raca(nome, mapOf("Força" to 1, "Constituição" to 1, "Destreza" to 1, "Sabedoria" to 1, "Inteligência" to 1, "Carisma" to 1))
                TipoRaca.ANAO -> Raca(nome, mapOf("Força" to 0, "Constituição" to 2, "Destreza" to 0, "Sabedoria" to 1, "Inteligência" to 0, "Carisma" to 0))
                TipoRaca.ELFO -> Raca(nome, mapOf("Força" to 0, "Constituição" to 0, "Destreza" to 2, "Sabedoria" to 0, "Inteligência" to 0, "Carisma" to 0))
                TipoRaca.HALFLING -> Raca(nome, mapOf("Força" to 0, "Constituição" to 0, "Destreza" to 2, "Sabedoria" to 0, "Inteligência" to 0, "Carisma" to 0))
                TipoRaca.GNOMO -> Raca(nome, mapOf("Força" to 0, "Constituição" to 0, "Destreza" to 1, "Sabedoria" to 0, "Inteligência" to 2, "Carisma" to 0))
                TipoRaca.MEIO_ELFO -> Raca(nome, mapOf("Força" to 0, "Constituição" to 0, "Destreza" to 0, "Sabedoria" to 0, "Inteligência" to 0, "Carisma" to 2))
                TipoRaca.MEIO_ORC -> Raca(nome, mapOf("Força" to 2, "Constituição" to 1, "Destreza" to 0, "Sabedoria" to 0, "Inteligência" to 0, "Carisma" to 0))
                TipoRaca.TIEFLING -> Raca(nome, mapOf("Força" to 0, "Constituição" to 0, "Destreza" to 0, "Sabedoria" to 0, "Inteligência" to 1, "Carisma" to 2))
            }
        }
    }
}
