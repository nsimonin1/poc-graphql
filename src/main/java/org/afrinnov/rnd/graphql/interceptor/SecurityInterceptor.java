package org.afrinnov.rnd.graphql.interceptor;

import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Slf4j
@Provider
public class SecurityInterceptor implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext context) throws IOException {
        log.info("{}", context.getHeaders());
    }
}
