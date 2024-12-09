import kotlin.reflect.typeOf

fun main(args: Array<String>) {
    println("Для выполнения первого задания введите 1, для выполнения второго 2, для третьего 3")
    val cont = readLine()!!.toInt()
    if (cont == 1) {
        mas1()
    } else if (cont == 2) {
        mas2()
    } else if (cont == 3) {
        mas3()
    } else {
        print("вы ошиблись")
    }
}
fun mas1() {
    println("Введите рост других учеников")
    val heights = readLine()?.split(" ")?.map { it.toInt() }?.toMutableList() ?: mutableListOf()

    println("Введите рост пети")
    val petyaHeight = readLine()?.toInt() ?: 0

    var position = 1
    for (height in heights) {
        if (height >= petyaHeight) {
            position++
        }
    }
    println(position)
}
fun mas2() {
    println("Введите максимальное число N")
    val n = readLine()?.toInt() ?: return

    var possibleNumbers = (1..n).toMutableSet()

    println("Введите количество операций")
    val m = readLine()?.toInt() ?: return

    repeat(m) {
        println("Введите числа")
        val input = readLine() ?: return
        val parts = input.split(" ")

        val answer = parts.last()
        val numbersInQuestion = parts.dropLast(1).map { it.toInt() }

        if (answer == "YES") {
            possibleNumbers.retainAll(numbersInQuestion)
        } else if (answer == "NO") {
            possibleNumbers.removeAll(numbersInQuestion)
        }
    }

    println(possibleNumbers.sorted().joinToString(" "))
}
fun mas3() {
    println("Введите количество стран")
    val m = readLine()?.toInt() ?: 0

    println("Введите Страну и города в ней")
    val countryMap = mutableMapOf<String, MutableSet<String>>()

    repeat(m) {
        val input = readLine() ?: ""
        val parts = input.split(":")
        val country = parts[0]
        val cities = parts[1].split(",").map { it.trim() }
        countryMap[country] = cities.toMutableSet()
    }

    println("Введите количество городов которые нужно проверить")
    val n = readLine()?.toInt() ?: 0

    repeat(n) {
        val city = readLine() ?: ""
        var found = false
        for ((country, cities) in countryMap) {
            if (city in cities) {
                println("$city находится в $country")
                found = true
                break
            }
        }
        if (!found) {
            println("Город $city не найден")
        }
    }
}


