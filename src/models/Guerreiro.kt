package strategies

class Guerreiro : ClassStrategy {
    override fun getClassName() = "Guerreiro"

    override fun applyClassModifiers(atributos: MutableMap<String, Int>) {
        atributos["Força"] = atributos["Força"]!! + 2
        atributos["Constituição"] = atributos["Constituição"]!! + 1
    }
}
