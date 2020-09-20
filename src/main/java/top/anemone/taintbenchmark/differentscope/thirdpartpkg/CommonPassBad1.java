package top.anemone.taintbenchmark.differentscope.thirdpartpkg;


import org.apache.commons.exec.util.StringUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/intraprocedural/IntraBad1")
public class CommonPassBad1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss");
        response.setContentType("text/html;");
        String res= StringUtils.fixFileSeparatorChar(source);
        PrintWriter out = response.getWriter();
        out.println(res); // sink
    }
}
