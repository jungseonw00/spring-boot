package com.inflearn.springboot

import com.inflearn.springboot.boot.MySpringApplication
import com.inflearn.springboot.boot.MySpringBootApplication

@MySpringBootApplication
class MySpringBootMain

fun main(args: Array<String>) {
    println("MySpringBootMain.main")
    MySpringApplication.run(MySpringBootMain::class.java, args)
}