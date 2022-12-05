fun main() {
    fun part1(input: List<String>): Int = input
        .splitByLine()
        .mapToPairOfRanges()
        .sumOfPairsThatOverlapEntirely()

    fun part2(input: List<String>): Int = input
        .splitByLine()
        .mapToPairOfRanges()
        .sumOfPairsThatOverlap()

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}

private fun List<String>.splitByLine(): List<List<String>> = map { line ->
    line.split(',')
}

private fun List<List<String>>.mapToPairOfRanges(): List<Pair<IntRange, IntRange>> = map { elfGroup ->
    val elfARange = elfGroup[0].split('-')
    val elfBRange = elfGroup[1].split('-')
    (elfARange[0].toInt()..elfARange[1].toInt()) to (elfBRange[0].toInt()..elfBRange[1].toInt())
}

private fun List<Pair<IntRange, IntRange>>.sumOfPairsThatOverlapEntirely() = sumOf { (elfARange, elfBRange) ->
    val addition: Int =
        if (elfARange.contains(elfBRange.first) && elfARange.contains(elfBRange.last) || elfBRange.contains(
                elfARange.first
            ) && elfBRange.contains(elfARange.last)
        ) 1 else 0
    addition
}

private fun List<Pair<IntRange, IntRange>>.sumOfPairsThatOverlap() = sumOf { (elfARange, elfBRange) ->
    val addition: Int = if(elfARange.any { elfBRange.contains(it) } || elfBRange.any { elfARange.contains(it) }) 1 else 0
    addition
}
