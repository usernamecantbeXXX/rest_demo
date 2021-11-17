package com.example.rest_demo.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.ArrayList;
/**
 * @author xxx
 * @since 2021/11/17 22:42
 */
@Configuration
public class HttpMessageConvertersConfig {

    /**
     * JSON序列化
     */
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

        // 添加 fastjson 的配置信息
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.WriteNullBooleanAsFalse,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.PrettyFormat);
        fastJsonConfig.setDateFormat("yyyy-MM-dd hh:mm:ss");
        fastConverter.setFastJsonConfig(fastJsonConfig);
        // 当 ContentType为application/json 时，此 converter 才会生效
        fastConverter.setSupportedMediaTypes(new ArrayList<MediaType>() {
            {
                add(MediaType.APPLICATION_JSON_UTF8);
                add(MediaType.APPLICATION_JSON);
            }
        });

        return new HttpMessageConverters((HttpMessageConverter<?>) fastConverter);
    }

}