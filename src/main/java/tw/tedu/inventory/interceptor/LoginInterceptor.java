package tw.tedu.inventory.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登錄攔截器
 * 已轉移至SpringSecurity處理
 */
public class LoginInterceptor implements HandlerInterceptor {

//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        //是否登錄
//        //獲取session對象
//        HttpSession session = request.getSession();
//        //判斷session中是否有uid
//        if(session.getAttribute("uid")==null){
//            response.sendRedirect("/login.html");
//            return false;
//        }
//        //放行
//        return true;
//    }
}
