fun main() {
    fun List<String>.splitListPerSegments(size: Int) = flatMap { it.windowed(size, 1) }

    fun List<String>.findDistinctSegment() =
        first { packet -> packet.all { character -> packet.count { it == character } == 1 } }

    fun List<String>.indexOfDistinctSegment(
        firstDistinctPacket: String,
        distinctSegmentSize: Int
    ): Int = first().indexOf(firstDistinctPacket) + distinctSegmentSize

    fun part1(input: List<String>): Int {
        val distinctSegmentSize = 4
        return input.splitListPerSegments(distinctSegmentSize).findDistinctSegment().run {
            input.indexOfDistinctSegment(this, distinctSegmentSize)
        }
    }

    fun part2(input: List<String>): Int {
        val distinctSegmentSize = 14
        return input.splitListPerSegments(distinctSegmentSize).findDistinctSegment().run {
            input.indexOfDistinctSegment(this, distinctSegmentSize)
        }
    }

    val input = readInput("Day06")
    println(part1(input))
    println(part2(input))
}
