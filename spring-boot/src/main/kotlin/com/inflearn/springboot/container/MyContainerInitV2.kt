package com.inflearn.springboot.container

import jakarta.servlet.ServletContainerInitializer
import jakarta.servlet.ServletContext
import jakarta.servlet.annotation.HandlesTypes

@HandlesTypes(AppInit::class)
class MyContainerInitV2(): ServletContainerInitializer {

    override fun onStartup(c: MutableSet<Class<*>>?, ctx: ServletContext?) {
        println("MyContainerInitV2.onStartup")
        println("c = ${c}")
        println("ctx = ${ctx}")

        for (clazz in c!!) {
            val appInit = clazz.getDeclaredConstructor().newInstance() as AppInit
            appInit.onStartup(ctx!!)
        }
    }
}