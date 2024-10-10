package strategies

interface SubRaceStrategy {
    fun getSubRaceName(): String
    fun applySubRaceModifiers(atributos: MutableMap<String, Int>)
}
