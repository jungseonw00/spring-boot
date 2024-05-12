package com.inflearn.springboot.container

import jakarta.servlet.ServletContext

class AppInitV1Servlet: AppInit {
    override fun onStartup(servletContext: ServletContext) {
        println("AppInitV1Servlet.onStartup")

        val helloServlet = servletContext.addServlet("helloServlet", HelloServlet())

        helloServlet.addMapping("/hello-servlet")
    }
}