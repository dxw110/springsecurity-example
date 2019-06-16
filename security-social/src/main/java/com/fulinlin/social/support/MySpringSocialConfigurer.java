/**
 *
 */
package com.fulinlin.social.support;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * 继承默认的社交登录配置，
 * 加入自定义的后处理逻辑
 *
 * @author zhailiang
 *
 */
public class MySpringSocialConfigurer extends SpringSocialConfigurer {

    private String filterProcessesUrl;


    public MySpringSocialConfigurer(String filterProcessesUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.config.annotation.SecurityConfigurerAdapter#postProcess(java.lang.Object)
     */
    @SuppressWarnings("unchecked")
    @Override
    protected <T> T postProcess(T object) {
        SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
        // SocialAuthenticationFilter过滤器默认拦截的请求是/auth开头，这里是修改为自己配置的
        return (T) filter;
    }

    public String getFilterProcessesUrl() {
        return filterProcessesUrl;
    }

    public void setFilterProcessesUrl(String filterProcessesUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
    }


}