package day2.second

import java.io.File

fun main() {
  val ids = getIds("./day2/input/input.txt")

  ids.mapIndexedNotNull { index, id ->
    ids.subList(index + 1, ids.size)
      .map { Pair(it, id) }
      .groupBy { it.first.filterIndexed { index, value -> value != it.second[index] }.count() }
      .filter { it.key == 1 }
      .map { it.value.first() }
      .firstOrNull()
  }
    .map { it.first.filterIndexed { index, value -> value == it.second[index] } }
    .distinct()
    .onEach { println(it) }
}

fun getIds(fileName: String) = File(fileName).readLines()