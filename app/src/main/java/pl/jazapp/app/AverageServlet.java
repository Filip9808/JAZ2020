package pl.jazapp.app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("average")
public class AverageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        resp.setStatus(200);
        resp.setContentType("text/plain");

        var numbers = req.getParameter("numbers");

        var writer = resp.getWriter();
        if(numbers==null) {
            writer.println("Please put parameters.");
        }
        else {

            writer.println("I got: '" + numbers + "'");
        }

   }
}
