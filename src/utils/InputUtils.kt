package utils

object InputUtils {
    fun promptUser(prompt: String): String {
        print("$prompt: ")
        return readLine()!!
    }

    fun promptUserForInt(prompt: String): Int {
        print("$prompt: ")
        return readLine()!!.toIntOrNull() ?: 0
    }
}
