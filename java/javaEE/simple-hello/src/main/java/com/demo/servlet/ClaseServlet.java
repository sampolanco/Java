/*
 * Copyright (c) 2020 The Eclipse Foundation and others.
 * 
 * This program and the accompanying materials are made available under 
 * the terms of the Eclipse Public License 2.0 which accompanies this
 * distribution, and is available at https://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Simple Hello World endpoint.
 * 
 * @author Ivar Grimstad (ivar.grimstad@eclipse-foundation.org)
 */
@WebServlet("/Servlet")
public class ClaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nombre = req.getParameter("nombre");

        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.print("<html>");
        printWriter.print("<body>");
        printWriter.print("<h1>Nombre en la url</h1>");
        printWriter.print("<p> nombre :: " + nombre + "</p>");
        printWriter.print("</body>");
        printWriter.print("</html>");
        printWriter.close();
    }
}
