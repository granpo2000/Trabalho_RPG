import models.*
import utils.InputUtils

fun limparTela() {
    try {
        if (System.getProperty("os.name").contains("Windows")) {
            Runtime.getRuntime().exec("cls")
        } else {
            Runtime.getRuntime().exec("clear")
        }
    } catch (e: Exception) {
        for (i in 0..50) {
            println()
        }
    }
}

fun main() {
    println("Bem-vindo ao Criador de Personagens de RPG!")

    val nome = InputUtils.promptUser("Digite o nome do seu personagem")
    limparTela()

    // Obtendo a raça
    val opcoesRaca = TipoRaca.values().joinToString { it.name }
    val escolhaRaca = InputUtils.promptUser("Escolha uma raça entre as seguintes opções: $opcoesRaca").uppercase()
    limparTela()
    val raca = Raca.obterRaca(TipoRaca.valueOf(escolhaRaca))

    // Obtendo a sub-raça, se aplicável
    val subRaca: SubRaca? = if (raca.nome in listOf(TipoRaca.ANAO, TipoRaca.ELFO, TipoRaca.HALFLING, TipoRaca.GNOMO)) {
        val opcoesSubRaca = when (raca.nome) {
            TipoRaca.ANAO -> listOf("ANÃO_DAS_COLINAS", "ANÃO_DAS_MONTANHAS")
            TipoRaca.ELFO -> listOf("ELFO_ALTO", "ELFO_DOS_FORES", "ELFO_DAS_OMBRA")
            TipoRaca.HALFLING -> listOf("HALFLING_DE_PÉS_LEVES", "HALFLING_FORTIFICADO")
            TipoRaca.GNOMO -> listOf("GNOME_DA_FLORA", "GNOME_ROCK")
            else -> emptyList()
        }.joinToString() + ", ou 'NÃO_USAR' para não escolher uma sub-raça"

        val escolhaSubRaca = InputUtils.promptUser("Escolha uma sub-raça entre as seguintes opções: $opcoesSubRaca").uppercase()
        limparTela()
        if (escolhaSubRaca == "NÃO_USAR") {
            null
        } else {
            SubRaca.obterSubRaca(TipoSubRaca.valueOf(escolhaSubRaca))
        }
    } else {
        null
    }

    // Obtendo a classe
    val opcoesClasse = TipoClasse.values().joinToString { it.name }
    val escolhaClasse = InputUtils.promptUser("Escolha uma classe entre as seguintes opções: $opcoesClasse").uppercase()
    limparTela()
    val classePersonagem = ClassePersonagem.obterClassePersonagem(TipoClasse.valueOf(escolhaClasse))

    // Criando o personagem e aplicando bônus
    val personagem = Personagem(nome, raca, subRaca, classePersonagem)
    personagem.aplicarBonus()

    // Distribuindo pontos entre atributos
    println("Você tem 27 pontos para distribuir entre seus atributos. Cada atributo pode receber no máximo 15 pontos.")
    var pontosRestantes = 27
    while (pontosRestantes > 0) {
        println("Atributos atuais: ${personagem.atributos}")
        val escolhaAtributo = InputUtils.promptUser("Qual atributo você gostaria de aumentar? (Força, Constituição, Destreza, Sabedoria, Inteligência, Carisma)").capitalize()
        limparTela()
        if (personagem.atributos.containsKey(escolhaAtributo)) {
            val pontosAdicionar = InputUtils.promptUserForInt("Quantos pontos você gostaria de adicionar? (Pontos restantes: $pontosRestantes)").coerceAtMost(pontosRestantes)
            limparTela()
            if (pontosAdicionar in 1..pontosRestantes) {
                val pontosAtuais = personagem.atributos[escolhaAtributo] ?: 0
                if (pontosAtuais + pontosAdicionar <= 15) {
                    personagem.atributos[escolhaAtributo] = pontosAtuais + pontosAdicionar
                    pontosRestantes -= pontosAdicionar
                } else {
                    println("Não é possível adicionar mais pontos a este atributo. O máximo é 15 pontos por atributo.")
                }
            } else {
                println("Número inválido de pontos.")
            }
        } else {
            println("Escolha de atributo inválida.")
        }
    }

    // Capturando a descrição e exibindo detalhes
    val descricao = InputUtils.promptUser("Digite uma descrição para o seu personagem")
    limparTela()

    println("\nCriação de Personagem Completa! Aqui estão os detalhes do seu personagem:")
    println("Nome: ${personagem.nome}")
    println("Raça: ${personagem.raca.nome}")
    subRaca?.let { println("Sub-Raça: ${it.nome}") }
    println("Classe: ${personagem.classePersonagem.nome}")
    println("Atributos: ${personagem.atributos}")
    println("Descrição: $descricao")
    println("${personagem.nome} está atualmente no nível 1.")
}
