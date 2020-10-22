package com.youlai.spring.circularreference.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.youlai.spring.circularreference.**")
public class ContextConfig {
}
