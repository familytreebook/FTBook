package com.mytime.Zuul.APIZuulServer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.JwtAccessTokenConverterConfigurer;
import org.springframework.boot.autoconfigure.security.oauth2.resource.JwtAccessTokenConverterRestTemplateCustomizer;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.List;
import java.util.Map;

@Configuration
@EnableResourceServer
//Spring Security默认禁用注解 这里开启注解
// 结合@PreAuthorize("hasRole('admin')")用来判断用户对某个控制层的方法是否有访问权限
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private  JwtAccessTokenConverter jwtTokenEnhancer;
/*    @Autowired
    private  List<JwtAccessTokenConverterConfigurer> configurers;
    @Autowired
    private  List<JwtAccessTokenConverterRestTemplateCustomizer> customizers;*/



    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
//                配置需要权限的url
                .authorizeRequests()
                .anyRequest().authenticated()
                .and().csrf().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        ;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("app").tokenStore(jwtTokenStore());
    }

    @Bean
    public JwtTokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtTokenEnhancer);
    }

    /*@Bean
    public JwtAccessTokenConverter jwtTokenEnhancer() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        String keyValue = this.resource.getJwt().getKeyValue();
        if (!StringUtils.hasText(keyValue)) {
            keyValue = getKeyFromServer();
        }
        if (StringUtils.hasText(keyValue) && !keyValue.startsWith("-----BEGIN")) {
            converter.setSigningKey(keyValue);
        }
        if (keyValue != null) {
            converter.setVerifierKey(keyValue);
        }
        if (!CollectionUtils.isEmpty(this.configurers)) {
            AnnotationAwareOrderComparator.sort(this.configurers);
            for (JwtAccessTokenConverterConfigurer configurer : this.configurers) {
                configurer.configure(converter);
            }
        }
        return converter;
    }

    private String getKeyFromServer() {
        RestTemplate keyUriRestTemplate = new RestTemplate();
        if (!CollectionUtils.isEmpty(this.customizers)) {
            for (JwtAccessTokenConverterRestTemplateCustomizer customizer : this.customizers) {
                customizer.customize(keyUriRestTemplate);
            }
        }
        HttpHeaders headers = new HttpHeaders();
        String username = this.resource.getClientId();
        String password = this.resource.getClientSecret();
        if (username != null && password != null) {
            byte[] token = Base64.getEncoder()
                    .encode((username + ":" + password).getBytes());
            headers.add("Authorization", "Basic " + new String(token));
        }
        HttpEntity<Void> request = new HttpEntity<>(headers);
        String url = this.resource.getJwt().getKeyUri();
        return (String) keyUriRestTemplate
                .exchange(url, HttpMethod.GET, request, Map.class).getBody()
                .get("value");
    }*/

}

//
//    /**
//     * 非对称加密算法对token进行签名
//     *
//     * @return
//     */
//    @Bean
//    public JwtAccessTokenConverter jwtAccessTokenConverter() {
//        final JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        // 导入证书
//        KeyStoreKeyFactory keyStoreKeyFactory =
//                new KeyStoreKeyFactory(new ClassPathResource("oauth2.jks"), "mypass".toCharArray());
//        converter.setKeyPair(keyStoreKeyFactory.getKeyPair("oauth2"));
//        return converter;
//    }

