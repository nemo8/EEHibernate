import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

@WebServlet("/cookie")
public class NotFound extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        String key= request.getParameter("name");
        Enumeration<String>list = session.getAttributeNames();
        pw.print("<h2>Attribute with that key is"+session.getAttribute(key)+"</h2>");
        pw.close();

        /*String key= request.getParameter("name");
        Cookie[]list=request.getCookies();
        Cookie res = null;
        if(list==null){
            pw.print("<h2>Cookie's list is empty</h2>");
            pw.close();
            return;
        }
            for (Cookie c:list){
                if (c.getName().equals(key)){
                    res=c;
                    break;
                }
            }
            if (res!=null)
                pw.print("<h2>Object value is "+res.getValue()+"</h2>");
            else
                pw.print("<h2>Object with required name is absent</h2>");
            pw.close();*/
    }
}
