package models

import strategies.ClassStrategy

class Barbaro : ClassStrategy {
    override fun getClassName() = "Bárbaro"

    override fun applyClassModifiers(atributos: MutableMap<String, Int>) {
        atributos["Força"] = atributos["Força"]!! + 2
        atributos["Constituição"] = atributos["Constituição"]!! + 1
    }
}
