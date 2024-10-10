package models

import strategies.ClassStrategy

class Clerigo : ClassStrategy {
    override fun getClassName() = "Clérigo"

    override fun applyClassModifiers(atributos: MutableMap<String, Int>) {
        atributos["Sabedoria"] = atributos["Sabedoria"]!! + 2
        atributos["Carisma"] = atributos["Carisma"]!! + 1
    }
}
