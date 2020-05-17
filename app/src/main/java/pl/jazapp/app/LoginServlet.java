package pl.jazapp.app;



import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;



@WebServlet("login")
public class LoginServlet extends HttpServlet {
    @Inject
    private UserContext userContext;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setStatus(200);
        resp.setContentType("text/plain");



        var respWriter = resp.getWriter();
        respWriter.println(String.format("My user id is: %d", userContext.getUserId()));



        if (userContext.getUserId() == null) {
            userContext.logIn(new Random().nextLong());
        }
    }
}