package com.inflearn.springboot.container

import jakarta.servlet.ServletContext

interface AppInit {
    fun onStartup(servletContext: ServletContext)
}