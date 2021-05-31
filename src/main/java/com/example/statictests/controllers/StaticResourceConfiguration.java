package com.example.statictests.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class StaticResourceConfiguration implements WebMvcConfigurer {
    Logger logger = LoggerFactory.getLogger(StaticResourceConfiguration.class);

    @Value("${file_upload_path}")
    private String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        logger.info("Uploads being served from - file:" + this.uploadPath);

        registry
                .addResourceHandler("/uploads/**")
                .addResourceLocations("file:" + this.uploadPath);
    }
}
