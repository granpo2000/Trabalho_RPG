package models

data class Personagem(
    var nome: String,
    var raca: Raca,
    var subRaca: SubRaca?,
    var classePersonagem: ClassePersonagem,
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
        raca.atributosBase.forEach { (chave, valor) -> atributos[chave] = atributos[chave]!! + valor }

        subRaca?.atributosAdicionais?.forEach { (chave, valor) -> atributos[chave] = atributos[chave]!! + valor }

        classePersonagem.atributosClasse.forEach { (chave, valor) -> atributos[chave] = atributos[chave]!! + valor }
    }
}
