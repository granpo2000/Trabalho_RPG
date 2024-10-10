package strategies

interface RaceStrategy {
    fun getRaceName(): String
    fun applyRaceModifiers(atributos: MutableMap<String, Int>)
}