/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.daphne.lazulite.common.web.filter;

import com.daphne.lazulite.common.utils.IpUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;

/**
 * <p>输出请求信息：URI、参数、header、cookie等</p>
 * <p>User: Zhang Kaitao
 * <p>Date: 13-1-18 上午7:22
 * <p>Version: 1.0
 */
public final class DebugRequestAndResponseFilter extends BaseFilter {
    private static final Logger log = LoggerFactory.getLogger("debugRequest");

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        if (log.isDebugEnabled()) {
            debugRequest(request);
        }
        chain.doFilter(request, response);

        if (log.isDebugEnabled()) {
            debugResponse(response);
        }
    }

    private void debugRequest(HttpServletRequest request) {
        log.debug("=====================request begin==========================");
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        if (StringUtils.isNotBlank(queryString)) {
            uri = uri + "?" + queryString;
        }
        log.debug("{}:{}", request.getMethod(), uri);
        log.debug("remote ip:{}  sessionId:{}  ", IpUtils.getIpAddr(request), request.getRequestedSessionId());
        log.debug("===header begin============================================");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String value = headersToString(request.getHeaders(name));
            log.debug("{}={}", name, value);
        }
        log.debug("===header   end============================================");
        log.debug("===parameter begin==========================================");
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            String value = StringUtils.join(request.getParameterValues(name), "||");
            log.debug("{}={}", name, value);
        }
        log.debug("===parameter   end==========================================");
        log.debug("=====================request   end==========================");
    }

    private String headersToString(Enumeration<String> headers) {
        StringBuilder s = new StringBuilder();
        int index = 0;
        while (headers.hasMoreElements()) {
            if (index > 0) {
                s.append("||");
            }
            s.append(headers.nextElement());
        }
        return s.toString();
    }

    private void debugResponse(HttpServletResponse response) {
        log.debug("=====================response begin==========================");
        log.debug("status:{}", response.getStatus(), response.getContentType());
        log.debug("contentType:{}, characterEncoding:{}", response.getContentType(), response.getCharacterEncoding());
        log.debug("===header begin============================================");
        Collection<String> headerNames = response.getHeaderNames();
        for (String name : headerNames) {
            String value = StringUtils.join(response.getHeaders(name), "||");
            log.debug("{}={}", name, value);
        }
        log.debug("===header   end============================================");
        log.debug("=====================response   end==========================");
    }
}
