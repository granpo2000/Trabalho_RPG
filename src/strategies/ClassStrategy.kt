package strategies

interface ClassStrategy {
    fun getClassName(): String
    fun applyClassModifiers(atributos: MutableMap<String, Int>)
}