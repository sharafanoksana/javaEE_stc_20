/**
 * @author Sharafan Oksana
 * @date 07.01.2020
 * @package com.gmail.sharafan.servlets
 */
package com.gmail.sharafan.servlets;

import com.gmail.sharafan.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/list"}, name = "ListServlet")
public class ListServlet extends HttpServlet {
//    public ListServlet() {
//    }
//
//    @Override
//    public void init() throws ServletException {
//        super.init();
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Model model = Model.getInstance();
        List<String> names = model.list();
        req.setAttribute("personUserNames", names);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/list.jsp");
        requestDispatcher.forward(req, resp);
    }
}
