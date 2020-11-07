package com.mytime.Zuul.ZuulServer.config;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyZuulForbiddenEntryPoint extends LoginUrlAuthenticationEntryPoint {
    private static final Log logger = LogFactory.getLog(MyZuulForbiddenEntryPoint.class);
    /**
     * @param loginFormUrl URL where the login page can be found. Should either be
     *                     relative to the web-app context path (include a leading {@code /}) or an absolute
     *                     URL.
     */
    public MyZuulForbiddenEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException arg2) throws IOException, ServletException {
        String acceptTypes = request.getHeader("Accept");
        if (logger.isDebugEnabled()) {
            logger.debug("zuul 自定义禁止访问端点");
            logger.debug("acceptTypes="+acceptTypes);
        }


        //如果是axios请求，返回状态码；因为axios请求中没有X-Requested-With,所以使用Header里面Accept来判断
        //其实正常情况下框架已经处理了，参见SsoSecurityConfigurer中81行，这里也是模拟框架的处理方式
        if(StringUtils.isNotEmpty(acceptTypes)&&acceptTypes.contains(MediaType.APPLICATION_JSON_VALUE)){
            //ajax类请求返回状态码，又前端进一步判断处理进行跳转
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Access Denied");
        }else{
            //普通网页form请求，报错后走这里，跳转到授权服务器登录界面验证
            super.commence(request, response, arg2);
        }

    }
}
