package memory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MemoryController (
    private val memoryFinder: MemoryFinder
) {

    @GetMapping("/memory")
    fun system(): Memory {
        val memory = memoryFinder.get()
        println("memory: ${memory}")
        return memory
    }
}