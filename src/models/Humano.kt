package strategies

class Humano : RaceStrategy {
    override fun getRaceName() = "Humano"

    override fun applyRaceModifiers(atributos: MutableMap<String, Int>) {
        atributos["Força"] = atributos["Força"]!! + 1
        atributos["Destreza"] = atributos["Destreza"]!! + 1
        atributos["Inteligência"] = atributos["Inteligência"]!! + 1
    }
}

class Anão : RaceStrategy {
    override fun getRaceName() = "Anão"

    override fun applyRaceModifiers(atributos: MutableMap<String, Int>) {
        atributos["Constituição"] = atributos["Constituição"]!! + 2
        atributos["Sabedoria"] = atributos["Sabedoria"]!! + 1
    }
}
