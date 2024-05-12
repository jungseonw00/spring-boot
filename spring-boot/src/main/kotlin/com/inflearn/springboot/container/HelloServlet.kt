package com.inflearn.springboot.container

import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

class HelloServlet : HttpServlet() {
    override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {
        println("HelloServlet.service")
        resp?.writer?.println("hello servlet!")
    }
}