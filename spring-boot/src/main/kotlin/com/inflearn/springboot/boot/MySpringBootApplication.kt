package com.inflearn.springboot.boot

import org.springframework.context.annotation.ComponentScan
import java.lang.annotation.*
import java.lang.annotation.Retention
import java.lang.annotation.Target

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ComponentScan
annotation class MySpringBootApplication() {

}
