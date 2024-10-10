package models

import strategies.SubRaceStrategy

class AnãoDasColinas : SubRaceStrategy {
    override fun getSubRaceName(): String {
        return "Anão das Colinas"
    }

    override fun applySubRaceModifiers(atributos: MutableMap<String, Int>) {
        // Modificadores específicos para Anão das Colinas
        atributos["Constituição"] = atributos["Constituição"]?.plus(2) ?: 10
    }
}

class AnãoDasMontanhas : SubRaceStrategy {
    override fun getSubRaceName(): String {
        return "Anão das Montanhas"
    }

    override fun applySubRaceModifiers(atributos: MutableMap<String, Int>) {
        // Modificadores específicos para Anão das Montanhas
        atributos["Força"] = atributos["Força"]?.plus(1) ?: 10
        atributos["Constituição"] = atributos["Constituição"]?.plus(1) ?: 10
    }
}
