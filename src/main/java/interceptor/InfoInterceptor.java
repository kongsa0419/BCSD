//package interceptor;
//
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Enumeration;
//
/*
Handler(=컨트롤러) 실행전: preHandle, 실행후: postHandle,
view 렌더링 후 : afterCompletion
HandlerInterceptor 인터페이스를 곧바로 구현하는 방법도 있겠다.
 */
//public class InfoInterceptor extends HandlerInterceptorAdapter {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("(interceptor) preHandle");
//        System.out.println("handler.toString() :"+handler.toString() +"\n\n");
////        System.out.println("[preHandle][" + request + "]" + "[" + request.getMethod()
////                + "]" + request.getRequestURI() + getParameters(request));
//        return true; //다음 핸들러 실행. false: 미실행(중단)
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("(interceptor) postHandle");
//        System.out.println("handler.toString() :: " + handler.toString());
//        System.out.println("handler.getClass() :: " + handler.getClass()+"\n\n");
//        super.postHandle(request, response, handler, modelAndView);
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("(interceptor) afterCompletion");
//        if(ex != null){
//            System.out.println( "Exception Message: " + ex.getMessage() + "\nException Cause: " + ex.getCause().toString() +"\n");
//        }
//        System.out.println("no exception"+"\n\n");
//        super.afterCompletion(request, response, handler, ex);
//    }
//
//
//
//// 긁어온 코드
//    private String getParameters(HttpServletRequest request) {
//        StringBuffer posted = new StringBuffer();
//        Enumeration<?> e = request.getParameterNames();
//        if (e != null) {
//            posted.append("?");
//        }
//        while (e.hasMoreElements()) {
//            if (posted.length() > 1) {
//                posted.append("&");
//            }
//            String curr = (String) e.nextElement();
//            posted.append(curr + "=");
//            if (curr.contains("password")
//                    || curr.contains("pass")
//                    || curr.contains("pwd")) {
//                posted.append("*****");
//            } else {
//                posted.append(request.getParameter(curr));
//            }
//        }
//        String ip = request.getHeader("X-FORWARDED-FOR");
//        String ipAddr = (ip == null) ? getRemoteAddr(request) : ip;
//        if (ipAddr!=null && !ipAddr.equals("")) {
//            posted.append("&_psip=" + ipAddr);
//        }
//        return posted.toString();
//    }
//
//    private String getRemoteAddr(HttpServletRequest request) {
//        String ipFromHeader = request.getHeader("X-FORWARDED-FOR");
//        if (ipFromHeader != null && ipFromHeader.length() > 0) {
//            System.out.println("ip from proxy - X-FORWARDED-FOR : " + ipFromHeader);
//            return ipFromHeader;
//        }
//        return request.getRemoteAddr();
//    }
//
//}
