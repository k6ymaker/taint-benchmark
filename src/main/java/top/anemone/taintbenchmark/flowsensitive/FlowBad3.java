package top.anemone.taintbenchmark.flowsensitive;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/flow/FlowBad2")
public class FlowBad3 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss");
        String ret = source;
        int cnt = 0;
        while (cnt < 2) {
            ret = "clean";
            cnt++;
        }
        response.setContentType("text/html;");
        PrintWriter out = response.getWriter();
        out.println(ret); // sink
    }
}
