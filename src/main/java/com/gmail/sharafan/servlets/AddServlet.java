/**
 * @author Sharafan Oksana
 * @date 07.01.2020
 * @package com.gmail.sharafan.servlets
 */
package com.gmail.sharafan.servlets;

import com.gmail.sharafan.dataBaseTables.UserPersonDao;
import com.gmail.sharafan.entities.PersonUser;
import com.gmail.sharafan.model.Model;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    @Inject
    private UserPersonDao userPersonDao;

    @Override
    public void init() throws ServletException {
        userPersonDao = (UserPersonDao) getServletContext().getAttribute("dao");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("PageTitle", "New PersonUser");
        req.setAttribute("FageBody", "form.jsp");
        req.getRequestDispatcher("views/add.jsp").forward(req,resp);
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/add.jsp");
//        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String password = req.getParameter("pass");
        PersonUser personUser = new PersonUser(name, password);
        userPersonDao.addUser(personUser);


//        Model model = Model.getInstance();
//        model.add(personUser);

//        req.setAttribute("personUserName", name);
//        req.setAttribute("personUserPassHash", password);
//        doGet(req, resp);

        resp.sendRedirect(req.getContextPath()+"/list");
    }
}
