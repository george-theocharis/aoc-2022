fun main() {

    val root = Node("/", null)
    val nodes = mutableListOf<Node>()
    var currentNode = root

    fun part1(input: List<String>): Long {
        input.forEach { command ->
            when {
                command == "$ cd /" -> currentNode = root
                command == "$ cd .." -> currentNode = currentNode.parent!!
                command.startsWith("$ cd") -> {
                    currentNode = currentNode.children.first { it.name == command.split(" ").last() }
                }

                command.startsWith("dir") -> Node(name = command.split(" ").last(), parent = currentNode)
                    .apply {
                        currentNode.children += this
                        nodes += this
                    }

                command.startsWith("$ ls") -> Unit
                else -> currentNode.size += command.split(" ").first().toLong()
            }
        }

        return nodes.filter { it.totalSize <= 100000L }.sumOf { it.totalSize }
    }

    fun part2(): Long {
        val spaceNeeded = 30000000 - (70000000 - root.totalSize)
        return nodes.filter { it.totalSize >= spaceNeeded }.minOf { it.totalSize }
    }

    val input = readInput("Day07")
    println(part1(input))
    println(part2())
}

class Node(
    val name: String,
    val parent: Node?,
    var children: List<Node> = emptyList()
) {

    var size: Long = 0L
    val totalSize: Long
        get() = size + children.sumOf { it.totalSize }
}
