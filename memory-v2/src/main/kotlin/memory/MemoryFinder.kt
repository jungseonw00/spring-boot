package memory

import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component

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