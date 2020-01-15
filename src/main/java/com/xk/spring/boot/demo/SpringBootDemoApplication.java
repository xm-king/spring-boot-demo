package com.xk.spring.boot.demo;

import com.xk.spring.boot.demo.config.DataProperties;
import com.xk.spring.boot.demo.dal.entity.UserEntity;
import com.xk.spring.boot.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Slf4j
@SpringBootApplication(scanBasePackages = "com.xk.spring.boot.demo")
public class SpringBootDemoApplication {

    public static void main(String[] args) {
       ApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);
       UserService userService =  context.getBean(UserService.class);
       List<UserEntity> userEntities = userService.queryAll();
       Assert.isTrue(!CollectionUtils.isEmpty(userEntities),"查询对象列表为空");
       DataProperties dataProperties = context.getBean(DataProperties.class);
       Assert.isTrue(dataProperties != null,"DataProperties对象为空");
    }

}
