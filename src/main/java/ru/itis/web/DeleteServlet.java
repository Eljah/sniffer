package ru.itis.web;

import org.apache.log4j.Logger;
import ru.itis.dao.DaoFactory;
import ru.itis.dao.SniffResultDao;
import ru.itis.pojo.SniffResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;

/**
 * Created by eljah32 on 10/11/2016.
 */

@WebServlet("/delete")
public class DeleteServlet  extends HttpServlet {

    static Logger log = Logger.getLogger(SnifferServlet.class);
    static SniffResultDao sniffResultDao = DaoFactory.getDAOFactory(1).getSniffResultDao();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String id=req.getParameter("id");
        String ref=req.getParameter("ref");
        resp.setContentType("text/html;charset=UTF-8");

        if (id!=null)
        {   SniffResult sniffResult=new SniffResult();
            sniffResult.setId(Long.parseLong(id));
            sniffResult=sniffResultDao.readSniffResult(sniffResult);
            sniffResultDao.deleteSniffResultBefore(sniffResult.getSniffingDate());}

        if (ref!=null)
        {   sniffResultDao.deleteSniffResultForReferer(ref);
        }
        resp.sendRedirect("admin");
    }
}
