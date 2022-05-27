package realpage.catalogbackend.configuration;


import java.io.IOException;
import java.io.Serializable;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;


/**
 * Filter used to validate the authentication
 * @author carlos.torres
 */
@Component
public class AuthenticationFilter implements AuthenticationEntryPoint, Serializable {
    
	private static final long serialVersionUID = 1L;

	@Override
    public void commence(HttpServletRequest request, HttpServletResponse response, org.springframework.security.core.AuthenticationException authException) throws IOException, ServletException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No authorized");
    }
    
}
