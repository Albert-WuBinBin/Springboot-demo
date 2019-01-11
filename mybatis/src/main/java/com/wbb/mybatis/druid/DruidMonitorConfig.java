//package com.wbb.mybatis.druid;
//
//import com.alibaba.druid.support.http.StatViewServlet;
//import com.alibaba.druid.support.http.WebStatFilter;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
/**
 * 配置druid监控
 * 可配置在配置文件中,也可以代码配置
 */
//@Configuration
//public class DruidMonitorConfig {
//
//
//    @Bean
//    public ServletRegistrationBean registrationBean(){
//        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
//
//        bean.addInitParameter("allow","127.0.0.1");
////        bean.addInitParameter("deny","127.0.0.1");
//        bean.addInitParameter("loginUsername","admin");
//        bean.addInitParameter("loginPassword","123456");
//        bean.addInitParameter("resetEnable","false");
//        return bean;
//    }
//    @Bean
//    public FilterRegistrationBean druidStatFilter() {
//        FilterRegistrationBean bean = new FilterRegistrationBean(new WebStatFilter());
//        //添加过滤规则.
//        bean.addUrlPatterns("/*");
//        //添加不需要忽略的格式信息.
//        bean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//        return bean;
//    }
//}
