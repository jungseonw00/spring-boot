package hello.selector

import org.springframework.context.annotation.ImportSelector
import org.springframework.core.type.AnnotationMetadata

class HelloImportSelector : ImportSelector {
    override fun selectImports(importingClassMetadata: AnnotationMetadata): Array<String> {
        return arrayOf("hello.selector.HelloConfig")
    }
}