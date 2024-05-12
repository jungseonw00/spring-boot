package hello.boot.memory

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.math.log

@RestController
class MemoryController(
    private val memoryFinder: MemoryFinder
) {

    @GetMapping("/memory")
    fun system(): Memory {
        val memory = memoryFinder.get()
        println("memory: ${memory}")
        return memory
    }
}