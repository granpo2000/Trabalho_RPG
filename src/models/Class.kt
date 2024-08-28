package models

enum class TipoClasse {
    BARBARO, BARDO, CLERIGO, DRUIDA, GUERREIRO, MONGE, PALADINO, PATRULHEIRO, LADINO, FEITICEIRO, BRUXO, MAGO
}

data class ClassePersonagem(
    val nome: TipoClasse,
    val atributosClasse: Map<String, Int>
) {
    companion object {
        fun obterClassePersonagem(nome: TipoClasse): ClassePersonagem {
            return when (nome) {
                TipoClasse.BARBARO -> ClassePersonagem(nome, mapOf("Força" to 2))
                TipoClasse.BARDO -> ClassePersonagem(nome, mapOf("Carisma" to 2))
                TipoClasse.CLERIGO -> ClassePersonagem(nome, mapOf("Sabedoria" to 2))
                TipoClasse.DRUIDA -> ClassePersonagem(nome, mapOf("Sabedoria" to 2))
                TipoClasse.GUERREIRO -> ClassePersonagem(nome, mapOf("Força" to 1, "Destreza" to 1))
                TipoClasse.MONGE -> ClassePersonagem(nome, mapOf("Destreza" to 2))
                TipoClasse.PALADINO -> ClassePersonagem(nome, mapOf("Força" to 2))
                TipoClasse.PATRULHEIRO -> ClassePersonagem(nome, mapOf("Destreza" to 2))
                TipoClasse.LADINO -> ClassePersonagem(nome, mapOf("Destreza" to 2))
                TipoClasse.FEITICEIRO -> ClassePersonagem(nome, mapOf("Carisma" to 2))
                TipoClasse.BRUXO -> ClassePersonagem(nome, mapOf("Carisma" to 2))
                TipoClasse.MAGO -> ClassePersonagem(nome, mapOf("Inteligência" to 2))
            }
        }
    }
}
