package top.anemone.taintbenchmark.convertchannel;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/implict/Interfacebad1")
public class ExceptionGood1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss");
        response.setContentType("text/html;");
        String ret = "success";

        try {
            FileInputStream file = new FileInputStream(source);
        } catch (IOException f) { // Not valid!
            ret = f.toString();
        } finally {
            ret = "success";
        }
        PrintWriter out = response.getWriter();
        out.println(ret); // sink
    }
}
