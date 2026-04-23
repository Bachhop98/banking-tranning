package com.nttdata.tranning.gateway.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config> {
    public AuthFilter(){
        super(Config.class);
    }
    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)){
                throw new RuntimeException("Missing authorization information");
            }
            String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
            String[] partAuths  = authHeader.split(" ");
            if(partAuths.length != 2 || "Bearer".equals(partAuths[0])) {
                throw new RuntimeException("Incorrect authorization information");
            }
            Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
            JWTVerifier jwtVerifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(partAuths[1]);
            String userName = decodedJWT.getSubject();
            if(StringUtils.isEmpty(userName)){
                throw new RuntimeException("Authorization error");
            }
            ServerHttpRequest request = exchange.getRequest().mutate()
                    .header("X-auth-username", userName)
                    .build();
            return chain.filter(exchange.mutate().request(request).build());
        };
    }

    static class Config{}
}