import models.*
import utils.InputUtils
import strategies.*

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

    // Não consideramos sub-raça neste exemplo
    val subRaca: SubRaceStrategy? = null

    // Obtendo a classe
    val opcoesClasse = TipoClasse.values().joinToString { it.name }
    val escolhaClasse = InputUtils.promptUser("Escolha uma classe entre as seguintes opções: $opcoesClasse").uppercase()
    limparTela()
    val classePersonagem = ClassePersonagem.obterClassePersonagem(TipoClasse.valueOf(escolhaClasse))

    // Criando o personagem
    val personagem = Personagem(nome, raca, subRaca, classePersonagem)

    // Permitir que o usuário insira os valores dos atributos manualmente
    println("Você pode inserir os valores para os atributos. Os valores devem estar entre 8 e 15 para cada atributo.")
    for (atributo in personagem.atributos.keys) {
        var valorAtributo: Int
        do {
            valorAtributo = InputUtils.promptUserForInt("Digite o valor para $atributo (8 a 15):")
        } while (valorAtributo < 8 || valorAtributo > 15)

        personagem.atributos[atributo] = valorAtributo
    }

    // Aplicando modificadores após a definição manual dos atributos
    personagem.aplicarBonus()

    // Capturando a descrição e exibindo detalhes
    val descricao = InputUtils.promptUser("Digite uma descrição para o seu personagem")
    limparTela()

    println("\nCriação de Personagem Completa! Aqui estão os detalhes do seu personagem:")
    println("Nome: ${personagem.nome}")
    println("Raça: ${personagem.raca.getRaceName()}")
    subRaca?.let { println("Sub-Raça: ${it.getSubRaceName()}") }
    println("Classe: ${personagem.classePersonagem.getClassName()}")
    println("Atributos: ${personagem.atributos}")
    println("Descrição: $descricao")
    println("${personagem.nome} está atualmente no nível 1.")
}
