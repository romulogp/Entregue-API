package br.com.avantis.entregue.api.cors;

import br.com.avantis.entregue.api.config.property.EntregueApiProperty;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

    @Autowired
    private EntregueApiProperty apiProperty;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        res.setHeader("Access-Control-Allow-Origin", apiProperty.getOriginPermitida());
        res.setHeader("Access-Control-Allow-Credentials", "true"); // Permitir envio do cookie do refresh_token

        if ("OPTIONS".equals(req.getMethod()) && isOriginPermitida(req)) {
            res.setHeader("Access-Control-Allow-Methods", "*"); // POST, GET, DELETE, PUT, OPTIONS");
            res.setHeader("Access-Control-Allow-Headers", "*"); //Authorization, Content-Type, Accept");
            res.setHeader("Access-Control-Max-Age", "3600"); // tempo para próxima requisição (CACHE BROWSER)

            res.setStatus(HttpServletResponse.SC_OK); // Retornar OK para o browser
        } else {
            chain.doFilter(request, response);
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    private boolean isOriginPermitida(HttpServletRequest req) {
        return apiProperty.getOriginPermitida().equals("*")
               || apiProperty.getOriginPermitida().equals(req.getHeader("Origin"));
    }

}
