package com.mytime.platform.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.mytime.platform.dto.GetTokenByCodeDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

@Service
public class UserService {
    private final static Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private RestTemplate restTemplate;
    // 熔断错误回调方法
    public String fallBack(GetTokenByCodeDto dto){
        return "Error occurre熔断错误!";
    }

    /**
     * 调用Eureka系统中名都为test-service的ribbon_service_a或ribbon_service_b的方法/hello
     * @return
     */
    // 注解指定发生错误时的回调方法
    @HystrixCommand(fallbackMethod="fallBack")
    public String getToken(GetTokenByCodeDto dto){
        dto.setClient_secret("123456");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded");
        // 组装body参数
        HashMap<String, String> postParameters = JSONObject.parseObject(JSONObject.toJSONString(dto), HashMap.class);
        HttpEntity<MultiValueMap<String, Object>> r = new HttpEntity<>(getParams(postParameters), headers);
        // 发起请求
        restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
        ResponseEntity<JSONObject> responseEntity = restTemplate.postForEntity("http://FTBook-AuthCenterServer/auth/oauth/token", r, JSONObject.class);
        JSONObject jsonObject = responseEntity.getBody();
        logger.info(JSONObject.toJSONString(responseEntity));
        return jsonObject.toJSONString();
    }

        public MultiValueMap getParams(Map<String,String> map) {
            MultiValueMap ret = new LinkedMultiValueMap();
            for(Iterator<Map.Entry<String, String>> itr = map.entrySet().iterator(); itr.hasNext();){
                Map.Entry<String, String> entry = itr.next();
                String key = entry.getKey();
                String value = entry.getValue();
                ret.put(key, new ArrayList(Arrays.asList(value)));
            }
            return ret;
        }
}
