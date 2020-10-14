package com.mytime.platform.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mytime.platform.dto.GetTokenByCodeDto;
import com.mytime.platform.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

//@RestController
//@RequestMapping("/user")
public class UserController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @GetMapping("/normal")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String normal( ) {
        return "用户页面";
    }

    @GetMapping("/medium")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String medium() {
        return "这也是用户页面";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String admin() {
        return "管理员页面";
    }

    @GetMapping("/getToken")
    public String getToken(@ModelAttribute GetTokenByCodeDto dto) {
        logger.info("获取token:{}",dto);

      /*  HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        // 组装body参数
        // 将map转为json串，放入restTemplate的参数对象中
        String bodyJsonData = JSONObject.toJSONString(dto);
        HttpEntity<String> request = new HttpEntity<>(bodyJsonData, headers);*/

        // 组装url参数 ?sex=1&age=2&classId=3
       /* MultiValueMap<String, String> queryMap = new LinkedMultiValueMap<>();
        queryMap.add("sex", "1");
        queryMap.add("age", "2");
        queryMap.add("classId", "3");*/

        // 将参数拼入请求url中
       /* UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Url + "/rack").queryParams(queryMap);
// 发起请求
        ResponseEntity<JSONObject> responseEntity = restTemplate.postForEntity(builder.toUriString(), request, JSONObject.class);
        System.out.println(builder.toUriString());
        System.out.println(responseEntity);*/

        return  userService.getToken(dto);
        //return model;
    }
}
