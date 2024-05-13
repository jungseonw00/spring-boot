package hello.selector

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

class ImportSelectorTest {

    @Test
    fun `정적으로 Config를 설정한다`() {
        val appContext =
            AnnotationConfigApplicationContext(StaticConfig::class.java)

        val bean = appContext.getBean(HelloBean::class.java)
        assertThat(bean).isNotNull
    }

    @Test
    fun `동적으로 Config를 설정한다`() {
        val appContext =
            AnnotationConfigApplicationContext(SelectorConfig::class.java)

        val bean = appContext.getBean(HelloBean::class.java)
        assertThat(bean).isNotNull
    }

    @Configuration
    @Import(HelloConfig::class)
    class StaticConfig

    @Configuration
    @Import(HelloImportSelector::class)
    class SelectorConfig
}