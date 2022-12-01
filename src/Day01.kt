fun main() {

    fun part1(input: List<String>): Int =
        input
            .fold(mutableListOf(0)) { acc: MutableList<Int>, item ->
                if (item.isNotEmpty()) {
                    acc[acc.lastIndex] = acc[acc.lastIndex] + item.toInt()
                } else {
                    acc.add(0)
                }
                acc
            }
            .max()

    fun part2(input: List<String>): Int = input
        .fold(mutableListOf(0)) { acc: MutableList<Int>, item ->
            if (item.isNotEmpty()) {
                acc[acc.lastIndex] = acc[acc.lastIndex] + item.toInt()
            } else {
                acc.add(0)
            }
            acc
        }
        .sortedDescending()
        .take(3)
        .sum()

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))

}