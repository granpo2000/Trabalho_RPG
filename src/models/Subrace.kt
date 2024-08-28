package models

enum class TipoSubRaca {
    ANAO_DAS_COLINAS, ANAO_DAS_MONTANHAS, ELFO_ALTO, ELFO_DOS_BOSQUES, ELFO_NEGRO, HALFLING_PES_LEVES, HALFLING_ROBUSTO, GNOMO_DA_FLORESTA, GNOMO_DAS_ROCHAS
}

data class SubRaca(
    val nome: TipoSubRaca,
    val atributosAdicionais: Map<String, Int>
) {
    companion object {
        fun obterSubRaca(nome: TipoSubRaca): SubRaca {
            return when (nome) {
                TipoSubRaca.ANAO_DAS_COLINAS -> SubRaca(nome, mapOf("Sabedoria" to 1, "Constituição" to 2))
                TipoSubRaca.ANAO_DAS_MONTANHAS -> SubRaca(nome, mapOf("Força" to 2, "Constituição" to 2))
                TipoSubRaca.ELFO_ALTO -> SubRaca(nome, mapOf("Destreza" to 2, "Inteligência" to 1))
                TipoSubRaca.ELFO_DOS_BOSQUES -> SubRaca(nome, mapOf("Destreza" to 2, "Sabedoria" to 1))
                TipoSubRaca.ELFO_NEGRO -> SubRaca(nome, mapOf("Destreza" to 2, "Carisma" to 1))
                TipoSubRaca.HALFLING_PES_LEVES -> SubRaca(nome, mapOf("Destreza" to 2, "Carisma" to 1))
                TipoSubRaca.HALFLING_ROBUSTO -> SubRaca(nome, mapOf("Destreza" to 2, "Constituição" to 1))
                TipoSubRaca.GNOMO_DA_FLORESTA -> SubRaca(nome, mapOf("Inteligência" to 2, "Destreza" to 1))
                TipoSubRaca.GNOMO_DAS_ROCHAS -> SubRaca(nome, mapOf("Inteligência" to 2, "Constituição" to 1))
            }
        }
    }
}
