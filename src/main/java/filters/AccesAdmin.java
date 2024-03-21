/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Thaïs GENIN
 */
//@WebFilter(urlPatterns = {"/accueilAdmin", "/ProfilAdmin"})
public class AccesAdmin implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        if (session != null && session.getAttribute("id_Utilisateur") != null) {
            int userId = (int) session.getAttribute("id_Utilisateur");
            if ((userId == 1) && req.getRequestURI().equals(req.getContextPath() + "/connexion")) {
                ((HttpServletResponse) response).sendRedirect(req.getContextPath() + "/accueilAdmin");
            } else {
                ((HttpServletResponse) response).sendError(403);
            }
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}
