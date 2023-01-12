import Default.DAOImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/create")
public class Create extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        DAOImp dao = new DAOImp(pw);

        try {
            String type = request.getParameter("type");
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age") );
            Pet pet = new Pet(type,name,age );
            dao.insert(pet);
            response.sendRedirect(request.getContextPath()+"/myApp");
        }catch (Exception ex){
            getServletContext().getRequestDispatcher("error/jsp").forward(request,response);
        }
    }
}
