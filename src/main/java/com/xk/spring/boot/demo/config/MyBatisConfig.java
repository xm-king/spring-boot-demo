package com.xk.spring.boot.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;

/**
 * @author pingchun@gegejia.com
 * @since 2020/1/14
 */
@Slf4j
@Configuration
@MapperScan("com.xk.spring.boot.demo.dal")
@EnableTransactionManagement
@ConfigurationProperties(prefix = "jdbc")
public class MyBatisConfig {

    private final static String MYSQL_SUFFIX="?useUnicode=true&characterEncoding=UTF8";

    /**
     * 数据库URL
     */
    String url;
    /**
     * 数据库用户名
     */
    String username;
    /**
     * 数据库密码
     */
    String password;

    /**
     * 平台写库
     * @return
     */
    @Bean(name = "dataSource")
    @Primary
    public DataSource writeDataSource() {
        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(url + MYSQL_SUFFIX);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
