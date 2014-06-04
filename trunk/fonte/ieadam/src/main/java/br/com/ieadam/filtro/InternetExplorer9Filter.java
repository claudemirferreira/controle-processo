/*
 * ANP - Agência Nacional do Petróleo, Gás Natural e Biocombustíveis
 * ANP - Todos os direitos reservados
 * -----------------------------------------------------------------
 *         Projeto: anp-framework-apresentacao-jar
 * Data de Criação: 19/03/2013
 *         Arquivo: InternetExplorer9Filter.java
 *           Autor: NIN - Arquitetura de Sistemas Java
 * -----------------------------------------------------------------
 */
package br.com.ieadam.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Filtro que emula o Internet Explorer 8
 * @author NIN - Arquitetura de Sistemas Java
 * @since 2.0.0
 */
public class InternetExplorer9Filter implements Filter {

    /**
     * {@inheritDoc}
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
        //Implementação obrigatória
    }

    /**
     * {@inheritDoc}
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
            throws IOException, ServletException {

        ((HttpServletResponse) response).setHeader("X-UA-Compatible", "IE=EmulateIE8");
        chain.doFilter(request, response);

    }

    /**
     * {@inheritDoc}
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {
        //Implementação de método obrigatória devido herança.
    }

}
