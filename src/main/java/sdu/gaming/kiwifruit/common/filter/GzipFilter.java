package sdu.gaming.kiwifruit.common.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 如果请求消息中包含gzip压缩数据，则进行解压
 *
 * @author
 *
 */
public class GzipFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        chain.doFilter(new GzipRequestWrapper((HttpServletRequest) request),
                response);
    }

    @Override
    public void destroy() {

    }

}
