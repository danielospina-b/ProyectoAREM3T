package edu.eci.arem.facturacion.webapi;

import java.io.IOException;
import java.io.PrintWriter;
import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Service;

/**
 *
 * @author daniel
 */
@Service
public class BasicAuthenticationPoint extends BasicAuthenticationEntryPoint {
    
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx) throws IOException, ServletException {  
        response.addHeader("WWW-Authenticate", "Basic realm=" +getRealmName());  
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);  
        PrintWriter writer = response.getWriter();  
        writer.println("HTTP Status 401 - " + authEx.getMessage());  
    }
    
    @Override  
    public void afterPropertiesSet() throws Exception {  
        setRealmName("Default");  
        super.afterPropertiesSet();  
    } 
    
}
