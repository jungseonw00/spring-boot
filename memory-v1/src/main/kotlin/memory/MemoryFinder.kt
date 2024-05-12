package hello.boot.memory

import jakarta.annotation.PostConstruct

class MemoryFinder {

    fun get(): Memory {
        val max = Runtime.getRuntime().maxMemory()
        val total = Runtime.getRuntime().totalMemory()
        val free = Runtime.getRuntime().freeMemory()
        val used = total - free
        return Memory(used, max)
    }

    @PostConstruct
    fun init() {
        println("MemoryFinder.init")
    }
}