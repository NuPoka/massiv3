fun main() {
    val alphabet = listOf('А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я')
    val shifts = listOf(1, 2, 20, 21, 5, 22, 23, 24, 8, 9, 10, 11, 32, 16, 17, 18, 19, 9, 30, 31, 12, 13, 14, 25, 26, 6, 7, 27, 28, 23, 4, 15, 33)

    println("Введите строку для шифровки или расшифровки:")
    val input = readLine()?.toUpperCase() ?: return

    println("Выберите режим работы: шифровка (1) или расшифровка (2)?")
    val mode = readLine()?.toInt() ?: return

    val output = when (mode) {
        1 -> encrypt(input, alphabet, shifts)
        2 -> decrypt(input, alphabet, shifts)
        else -> "Некорректный режим работы"
    }

    println("Результат: $output")
}

fun encrypt(input: String, alphabet: List<Char>, shifts: List<Int>): String {
    val result = StringBuilder()
    for (c in input) {
        val index = alphabet.indexOf(c)
        if (index != -1) {
            val shiftedIndex = (index + shifts[index % 33]) % 33
            result.append(alphabet[shiftedIndex])
        } else {
            result.append(c)
        }
    }
    return result.toString()
}

fun decrypt(input: String, alphabet: List<Char>, shifts: List<Int>): String {
    val result = StringBuilder()
    for (c in input) {
        val index = alphabet.indexOf(c)
        if (index != -1) {
            var shiftedIndex = (index - shifts[index % 33]) % 33
            if (shiftedIndex < 0) {
                shiftedIndex += 33
            }
            result.append(alphabet[shiftedIndex])
        } else {
            result.append(c)
        }
    }
    return result.toString()
}