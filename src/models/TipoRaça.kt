package strategies

enum class TipoRaca {
    HUMANO,
    ANÃO
}

enum class TipoClasse {
    GUERREIRO
}

object Raca {
    fun obterRaca(tipo: TipoRaca): RaceStrategy {
        return when (tipo) {
            TipoRaca.HUMANO -> Humano()
            TipoRaca.ANÃO -> Anão()
        }
    }
}

object ClassePersonagem {
    fun obterClassePersonagem(tipo: TipoClasse): ClassStrategy {
        return when (tipo) {
            TipoClasse.GUERREIRO -> Guerreiro()
        }
    }
}
