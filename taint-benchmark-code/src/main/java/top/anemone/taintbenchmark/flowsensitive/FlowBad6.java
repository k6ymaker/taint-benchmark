package top.anemone.taintbenchmark.flowsensitive;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/flow/FlowBad1")
public class FlowBad6 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss");
        response.setContentType("text/html;");
        String ret;
        for (int i = 0; ; i++) {
            if (i==4){
                ret = source;
                break;
            }
            ret = "clean";
        }
        PrintWriter out = response.getWriter();
        out.println(source); // sink
    }
}
