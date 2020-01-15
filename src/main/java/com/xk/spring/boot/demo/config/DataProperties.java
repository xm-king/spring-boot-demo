package com.xk.spring.boot.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author pingchun@gegejia.com
 * @since 2020/1/15
 */
@Component
@ConfigurationProperties(prefix = "env")
@Data
public class DataProperties {

    private String data;
}
