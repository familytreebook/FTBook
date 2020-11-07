package com.mytime.authCenterServer.config;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author lvhaibao
 * @description
 * @date 2018/12/26 0026 18:19
 */
@Component
public class FormLoginConstant {

    public static final String LOGIN_PAGE_URL = "/authentication/require";

    public static final String LOGIN_PROCESSING_URL = "/authentication/form";

    public static final String LOGING_PAGE_PAGEURL = "/oauthLogin";

    public static final String GRANT_PAGE_PAGEURL = "/oauthGrant";




}
