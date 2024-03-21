/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thaïs GENIN
 */
@WebServlet("/accueilAdmin")
public class AccueilAdmin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding(StandardCharsets.UTF_8.toString());
//        req.setAttribute("AdminListeNouvelles", req);
//        req.setAttribute(name, req);
//        req.setAttribute(name, req);
        req.getRequestDispatcher("/WEB-INF/accueilAdmin.jsp").forward(req, resp);
    }
}
