import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/Ola")
public class OlaServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String nome = request.getParameter("nome");
        if (nome == null)
            nome = "camarada";
        response.getWriter().print("<html><h1>Oi "+ nome + "!</h1></html>");
    }
}
