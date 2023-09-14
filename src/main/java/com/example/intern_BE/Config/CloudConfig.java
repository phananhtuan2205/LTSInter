package com.example.intern_BE.Config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudConfig {
    @Bean
    public Cloudinary getCloudinary(){
        Map config = new HashMap();
        config.put("cloud_name","dsep9jsiq");
        config.put("api_key","351284216934358");
        config.put("api_secret","27hsddzStRPULzKTVqfVKLXK_3A");


        return new Cloudinary(config);
    }

}
