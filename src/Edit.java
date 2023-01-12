import Default.DAOImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/edit")
public class Edit extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));
        DAOImp dao = new DAOImp(pw);

        try {
            Pet pet = dao.selectOne(id);
            if (pet==null)
                getServletContext().getRequestDispatcher("/error.jsp");
            request.setAttribute("type",pet.getType());
            request.setAttribute("name",pet.getName());
            request.setAttribute("age",pet.getAge());
            request.setAttribute("id",id);
            getServletContext().getRequestDispatcher("/edit.jsp").forward(request,response);
        }catch (Exception ex){
            getServletContext().getRequestDispatcher("/error.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        DAOImp dao = new DAOImp(pw);

        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String type = req.getParameter("type");
            String name = req.getParameter("name");
            int age = Integer.parseInt(req.getParameter("age"));
            Pet pet = new Pet(id,type,name,age);
            dao.update(pet);
            resp.sendRedirect(req.getContextPath()+"/myApp");
        }catch (Exception ex){
            getServletContext().getRequestDispatcher("/error.jsp").forward(req,resp);
        }
    }
}
