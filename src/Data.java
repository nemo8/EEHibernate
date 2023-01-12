import DAO.DAOImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/myApp")
public class Data extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        DAOImp dao = new DAOImp(pw);
        List<Pet>list = dao.selectAll();

        request.setAttribute("pets",list);
        getServletContext().getRequestDispatcher("/data.jsp").forward(request,response);
        pw.close();


        /*  Cookie men = new Cookie("men","den");
        men.setMaxAge(60);
        Cookie women = new Cookie("women","vee");
        women.setMaxAge(60);
        response.addCookie(men);
        response.addCookie(women);
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");
        pw.print("<h2>Cookies are set</h2>");
        pw.close();
        */
        /*response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        String id = request.getParameter("id");
        ArrayList<Users>list = new ArrayList<>();
        list.add(new Users("7","den"));
        list.add(new Users("10","vee"));
        for (Users c:list) {
            if (c.id.equals(id)){
                pw.println("<h2>User's id name is "+c.name+"</h2>");
                return;
            }
        }
        String path = "/notFound";
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(request,response);*/

        /*String path = "/notFound";
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(request,response);
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String[] names= request.getParameterValues("names");
        for(String c:names)
        writer.println("<h2>"+c+"</h2>");
        writer.close();*/
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int res=0;
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String action = req.getParameter("action");
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        switch (action){
            case ("sum"):
                res=Integer.parseInt(num1)+Integer.parseInt(num2);
                break;
            case ("sub"):
                res=Integer.parseInt(num1)-Integer.parseInt(num2);
                break;
            case ("mult"):
                res=Integer.parseInt(num1)*Integer.parseInt(num2);
                break;
            case ("div"):
                res=Integer.parseInt(num1)/Integer.parseInt(num2);
                break;
            default:
                pw.println("<h2>wrong action</h2>");
                break;
        }
        pw.println("<h2> Result is "+res+"</h2>");
        pw.close();

    }
}
