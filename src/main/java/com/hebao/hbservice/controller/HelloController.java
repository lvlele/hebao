package com.hebao.hbservice.controller;

import com.hebao.hbservice.bean.CommonProperties;
import com.hebao.hbservice.bean.People;
import com.hebao.hbservice.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by 薏生科技 on 2017/10/11.
 */
@RestController

// 添加日志
@Slf4j

@EnableConfigurationProperties(value = CommonProperties.class)
public class HelloController {

    @Autowired
    private CommonProperties commonProperties;

    @Autowired
    private TestService testService;

    // 获取配置文件属性
    @Value("${demo.configStr:defaultValue}")
    private String configStr;

    // list类型配置
    @Value("#{'${demo.listParam}'.split(',')}")
    private List<String> listParam;

    // map类型配置
    @Value("#{${demo.mapParam}}")
    private Map<String, String> map;

    /**
     * 测试http请求
     * @param name
     * @return
     */
    @RequestMapping("/hello")
    public String sayHello(String name) {
        // 直接获取log对象
        log.info("configStr is: {}", configStr);
        return "hello my name is: " + name;
    }

    /**
     * 测试缓存
     * @return
     */
    @RequestMapping("/getRedis")
    public String getRedis() {
        String str = testService.getRedis();
        System.out.println(str);
        return str;
    }

    /**
     * 测试缓存
     * @return
     */
    @RequestMapping("/setRedis")
    public String setRedis() {
        People p = new People();
        p.setAge(10);
        p.setId(1);
        p.setName("tom");
        testService.setRedis(p);
        return "ok";
    }

    @RequestMapping("/queryMybatis")
    @ResponseBody
    public Object queryMybatis(int pageNum, int pageSize) {
        return testService.queryMybatis(pageNum, pageSize);
    }

    @RequestMapping("/commonConfig")
    public String getCommonConfig() {
        log.debug("common config is {}", commonProperties.toString());
        log.info("listParam is {}", listParam);
        log.info("mapParam is {}", map);
        return "common config is: " + commonProperties.toString();
    }
}
