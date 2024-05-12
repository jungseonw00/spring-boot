package com.inflearn.springboot.container

import com.inflearn.springboot.spring.HelloConfig
import jakarta.servlet.ServletContext
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet

class AppInitV2Spring : AppInit {

    override fun onStartup(servletContext: ServletContext) {
        println("AppInitV2Spring.onStartup")

        // 스프링 컨테이너 생성
        val appContext = AnnotationConfigWebApplicationContext()
        appContext.register(HelloConfig::class.java)

        // 스프링 MVC 디스패처 서블릿 생성, 스프링 컨테이너 연결
        val dispatcher = DispatcherServlet(appContext)

        // 디스패처 서블릿을 서블릿 컨테이너에 등록
        val servlet = servletContext.addServlet("dispatcherV2", dispatcher)

        // /spring/* 요청이 디스패처 서블릿을 통하도록 설정
        servlet.addMapping("/spring/*")
    }
}