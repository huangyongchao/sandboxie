package app.interceptor;

import app.repository.SandboxieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URL;

@Component("pathInterceptor")
public class PathInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse response, Object o) throws Exception {
        String url = req.getRequestURI();
        System.out.println(req.getRequestURL());
        if(url.indexOf("/sandbox")==-1 && url.indexOf("/restsandbox")==-1 ){
            req.setAttribute("p",url);

            req.getRequestDispatcher("/restsandbox/").forward(req,response);
            return false;

        }else{
            return true;

        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}