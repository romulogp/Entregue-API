package br.com.avantis.entregue.api.event;

import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

public class RecursoCriadoEvent extends ApplicationEvent {

    private final HttpServletResponse response;
    private final Long codigoRecurso;

    public RecursoCriadoEvent(Object source, HttpServletResponse response, Long codigo) {
        super(source);
        this.response = response;
        this.codigoRecurso = codigo;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public Long getCodigoRecurso() {
        return codigoRecurso;
    }

}
