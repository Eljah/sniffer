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
import java.sql.SQLException;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * Created by eljah32 on 10/11/2016.
 */

@WebServlet("/snf")
public class SnifferServlet extends HttpServlet {

    static Logger log = Logger.getLogger(SnifferServlet.class);
    static SniffResultDao sniffResultDao = DaoFactory.getDAOFactory(1).getSniffResultDao();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        SniffResult sniffResult= new SniffResult();
        sniffResult.setSniffingDate(new Date());
        Map<String,String[]> passedParameters=req.getParameterMap();
        Enumeration<String> parameters=req.getParameterNames();
        String parameterValueToBeAssignedAsXssResult=null;
        while (parameters.hasMoreElements())
        {
           String[] parametersArray=passedParameters.get(parameters.nextElement());
            for (String par:parametersArray)
            {
                if (par!=null) {
                    parameterValueToBeAssignedAsXssResult=par;
                }
            }
        }

        sniffResult.setHijackedUrl(parameterValueToBeAssignedAsXssResult);
        sniffResult.setReferer(req.getHeader("referer"));
        log.debug("Trips and plans list is got from the db");
        sniffResultDao.create(sniffResult);

        getServletContext().getRequestDispatcher("/i.jpg").forward(req, resp);
    }
}
