package memory

import hello.boot.memory.MemoryFinder
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MemoryFinderTest {

    @Test
    fun `객체를 조회한다`() {
        val memoryFinder = MemoryFinder()
        val memory = memoryFinder.get()
        println("memory = ${memory}")
        assertThat(memory).isNotNull
    }
}