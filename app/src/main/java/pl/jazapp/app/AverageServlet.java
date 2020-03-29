package pl.jazapp.app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

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

            String[] arrOfNumbers = numbers.split(",");
            double suma = 0;

            for(int i=0; i<arrOfNumbers.length; i++)
            {
                double tmp = Double.parseDouble(arrOfNumbers[i]);
                suma += tmp;

            }
            double srednia = suma / arrOfNumbers.length;
            BigDecimal tmp = BigDecimal.valueOf(srednia);
            DecimalFormat sredniaA = new DecimalFormat( "###.##");
            writer.println("Average equals: " + sredniaA.format(tmp).replace(",",".") + "'");

            }

   }
}
