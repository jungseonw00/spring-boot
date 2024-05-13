package memory

import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean

@AutoConfiguration
@ConditionalOnProperty(name = ["memory"], havingValue = "on")
class MemoryAutoConfig {

    @Bean
    fun memoryFinder(): MemoryFinder {
        return MemoryFinder()
    }

    @Bean
    fun memoryController(): MemoryController {
        return MemoryController(memoryFinder())
    }
}