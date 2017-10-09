package org.teamshine.pangoo.multipart;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;

/**
 * 使PUT方法支持文件上传
 */
public class RestMultipartResolver extends CommonsMultipartResolver implements InitializingBean {
    private final static String MULTIPART = "multipart/";

    @Override
    public void setMaxUploadSize(long maxUploadSize) {
        super.setMaxUploadSize(maxUploadSize * 1024 * 1024);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setDefaultEncoding("UTF-8");
    }

    @Override
    public boolean isMultipart(HttpServletRequest request) {
        return request != null && isMultipartContent(request);
    }

    private boolean isMultipartContent(HttpServletRequest request){
        if ("get".equalsIgnoreCase(request.getMethod())){
            return false;
        }

        String contentType = request.getContentType();
        return contentType != null && contentType.toLowerCase().startsWith(MULTIPART);
    }
}
