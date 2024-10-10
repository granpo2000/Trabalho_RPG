package models

import strategies.ClassStrategy

class Mago : ClassStrategy {
    override fun getClassName() = "Mago"

    override fun applyClassModifiers(atributos: MutableMap<String, Int>) {
        atributos["Inteligência"] = atributos["Inteligência"]!! + 2
        atributos["Sabedoria"] = atributos["Sabedoria"]!! + 1
    }
}
