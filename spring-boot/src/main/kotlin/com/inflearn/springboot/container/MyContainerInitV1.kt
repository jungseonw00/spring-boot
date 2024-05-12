package com.inflearn.springboot.container

import jakarta.servlet.ServletContainerInitializer
import jakarta.servlet.ServletContext

class MyContainerInitV1 : ServletContainerInitializer {

    override fun onStartup(p0: MutableSet<Class<*>>?, p1: ServletContext?) {
        println("MyContainerInitV1.onStartup")
        println("javaClass = ${javaClass}")
    }
}