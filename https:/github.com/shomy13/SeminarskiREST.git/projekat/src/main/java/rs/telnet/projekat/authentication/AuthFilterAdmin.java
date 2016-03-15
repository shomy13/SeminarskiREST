package rs.telnet.projekat.authentication;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import io.jsonwebtoken.Jwts;

@SecureAdmin
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthFilterAdmin implements ContainerRequestFilter{

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		// TODO Auto-generated method stub
String AuthHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
		
		if(AuthHeader == null || !AuthHeader.startsWith("Bearer")){
			throw new NotAuthorizedException("Authorization header must be provided");
		}
		
		String token =AuthHeader.substring("Bearer".length()).trim();
		
		try {
			
			validateToken(token);
			
			
		} catch (Exception e) {
			requestContext.abortWith(
			Response.status(Response.Status.UNAUTHORIZED).build());
		}
	}
	private void validateToken(String token) throws Exception{
		  Jwts.parser().setSigningKey("kljucic").require("admin", "1").parseClaimsJws(token);
		  
	}

}
