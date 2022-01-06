package vn.com.stanford.je0821.springmvcbasic.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        HttpSession session = request.getSession();

        if(session != null && session.getAttribute("userOnline") != null)
        {
            System.out.println("Bạn đang đăng nhập với user: " + session.getAttribute("userOnline") );
        }
        else
        {
            response.sendRedirect("../dang-nhap");
        }
        return super.preHandle(request, response, handler);
    }
}
