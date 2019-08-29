package com.jdz.servermall.config;

import com.alibaba.fastjson.JSONObject;
import com.jdz.jdzcommon.config.LogHelperConfig;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 配置拦截器
 */
public class Interceptor implements HandlerInterceptor {

    /**
     * 请求开始时间
     */
    private static final String START_TIME = "requestStartTime";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取进入方法的时间
        long start = System.currentTimeMillis();
        request.setAttribute(START_TIME, start);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        String url = request.getRequestURI();
        Map parameterMap = request.getParameterMap();
        long start = (Long) request.getAttribute(START_TIME);
        long end = System.currentTimeMillis();
        LogHelperConfig.writeLog("Interceptor", "postHandle", "方法路径:" + url, "入参:" + JSONObject.toJSONString(parameterMap), "耗时：" + (end - start));

    }
}
