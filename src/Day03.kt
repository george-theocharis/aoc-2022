fun main() {
    fun part1(input: List<String>): Int = input
        .splitByElf()
        .findCommonItem()
        .sumOfPriorities()

    fun part2(input: List<String>): Int = input
        .splitByGroupOfElves()
        .findGroupBadge()
        .sumOfPriorities()

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}

private fun List<String>.splitByElf() = map { items ->
    val halfSize = items.length / 2
    items.substring(0, halfSize) to items.substring(halfSize, items.length)
}

private fun List<Pair<String, String>>.findCommonItem() = map { (firstItem, secondItem) ->
    firstItem.first {
        secondItem.contains(it)
    }
}

private fun List<Char>.sumOfPriorities() = sumOf {
    if (it.isLowerCase()) {
        ('a'..'z').indexOf(it) + 1
    } else {
        (('A'..'Z').indexOf(it) + 27)
    }
}

private fun List<String>.splitByGroupOfElves(): List<List<String>> = chunked(3)


private fun List<List<String>>.findGroupBadge() = map { group ->
    group.toItems()
        .first()
        .first { character ->
            group.toItems()
                .mapNotNull { line: List<Char> -> if (line.contains(character)) character else null }
                .size == group.size
        }
}

private fun List<String>.toItems(): List<List<Char>> = map { it.toCharArray().toList() }