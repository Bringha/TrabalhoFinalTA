
package br.edu.ifsul.filtros;

import br.edu.ifsul.controle.ControleLogin;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author Jorge Luis Boeira Bavaresco
 * jorge.bavaresco@passofundo.ifsul.edu.br
 */
@WebFilter(urlPatterns = "/restrito/*")
public class FiltroSeguranca implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // recuperando a requisição e resposta
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        // recuperando a sessão
        HttpSession sessao = httpRequest.getSession();
        String contextPath = httpRequest.getContextPath();
        // obtendo o controleLogin da sessão
        ControleLogin controleLogin = (ControleLogin) sessao.getAttribute("controleLogin");
        // testo se o usuario existe na sessão
        if (controleLogin == null || controleLogin.getUsuarioLogado() == null){
            // se não existe redireciono para a pagina de login
            httpResponse.sendRedirect(contextPath+"/publico/login.xhtml");
        }
        chain.doFilter(request, response);                
    }

    @Override
    public void destroy() {
       
    }
}
