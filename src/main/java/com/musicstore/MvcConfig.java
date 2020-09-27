package com.musicstore;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/index").setViewName("home");
    registry.addViewController("/").setViewName("home");
    registry.addViewController("/about").setViewName("about");
    registry.addViewController("/careers").setViewName("careers");
    registry.addViewController("/album/add").setViewName("add");
    registry.addViewController("/login").setViewName("login");
  }

}