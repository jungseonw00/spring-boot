package com.inflearn.springboot.boot

import org.apache.catalina.LifecycleException
import org.apache.catalina.connector.Connector
import org.apache.catalina.startup.Tomcat
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet
import java.nio.file.Files


class MySpringApplication {
    companion object {
        fun run(configClass: Class<*>, args: Array<String>) {
            println("EmbedTomcatSpringMain.main")

            val tomcat = Tomcat()
            val connector = Connector()
            connector.port = 8080
            tomcat.connector = connector

            val appContext = AnnotationConfigWebApplicationContext()
            appContext.register(configClass)

            val dispatcher = DispatcherServlet(appContext)

            val context = tomcat.addContext("", "/")
            tomcat.addServlet("", "dispatcher", dispatcher)
            context.addServletMappingDecoded("/", "dispatcher")
            try {
                tomcat.start()
            } catch (e: LifecycleException) {
                println("tomcat start fail: " + e.message)
                throw RuntimeException(e)
            }
        }
    }
}