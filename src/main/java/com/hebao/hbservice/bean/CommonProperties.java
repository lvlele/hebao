package com.hebao.hbservice.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * Created by 薏生科技 on 2017/10/12.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "common")
@Validated
// @Data注解toString()排除password属性
@ToString(exclude = "password")
public class CommonProperties {

    @NotNull
    private String host;

    @NotNull
    private String port;

    @NotNull
    private String username;

    private String password;

    private List<String> list;

    private Map<String, String> map;
}
