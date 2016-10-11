package ru.itis.dao;

import ru.itis.pojo.SniffResult;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Ilya Evlampiev on 02.11.2015.
 */
public class MySQLSniffResultDao extends MySqlDao implements SniffResultDao {
    @Override
    public void create(SniffResult sniffResult) {
        PreparedStatement stmt = null;
        Connection con = getConnection();

        try {
            stmt = con.prepareStatement("INSERT INTO sniffresult (referer, hijackedurl,sniffdate) VALUES( ?,?,?)");
            stmt.setString(1, sniffResult.getReferer());
            stmt.setString(2, sniffResult.getHijackedUrl());
            stmt.setTimestamp(3,  new java.sql.Timestamp(sniffResult.getSniffingDate().getTime()));
            stmt.execute();
            //log.trace("Addition to notes by user " + note.getUser().getUsername());
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            //log.error("Addition of new comment failed " + e.getLocalizedMessage());
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public SniffResult readSniffResult(SniffResult sniffResult) {
        String sql = "SELECT * FROM sniffresult WHERE id = ?";
        SniffResult sniffResult1 = new SniffResult();
        PreparedStatement stm = null;
        Connection con = getConnection();
        try {
            stm = con.prepareStatement(sql);
            stm.setLong(1, sniffResult.getId());
            ResultSet rs = stm.executeQuery();
            rs.next();

            sniffResult1.setId(rs.getLong("id"));
            sniffResult1.setReferer(rs.getString("referer"));
            sniffResult1.setHijackedUrl(rs.getString("hijackedurl"));
            sniffResult1.setSniffingDate(rs.getTimestamp("sniffdate"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stm.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return sniffResult1;
    }


    @Override
    public List<SniffResult> readAllSniffResults() {
        String sql = "SELECT * FROM sniffresult";
        List<SniffResult> sniffResultList = new ArrayList<SniffResult>();
        PreparedStatement stm = null;
        Connection con = getConnection();
        try {
            stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()
                    ) {
                SniffResult sniffResult = new SniffResult();
                sniffResult.setId(rs.getLong("id"));
                sniffResult.setReferer(rs.getString("referer"));
                sniffResult.setHijackedUrl(rs.getString("hijackedurl"));
                sniffResult.setSniffingDate(rs.getTimestamp("sniffdate"));
                sniffResultList.add(sniffResult);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stm.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return sniffResultList;
    }

    @Override
    public void deleteSniffResult(SniffResult sniffResult) {
        PreparedStatement stmt = null;
        Connection con = getConnection();
        try {
            stmt = con.prepareStatement("DELETE FROM sniffresults WHERE id = ?");
            stmt.setLong(1, sniffResult.getId());
            stmt.execute();
            //log.trace("Addition to notes by user " + note.getUser().getUsername());
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            //log.error("Addition of new comment failed " + e.getLocalizedMessage());
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void deleteSniffResultBefore(Date date) {
        PreparedStatement stmt = null;
        Connection con = getConnection();
        try {
            stmt = con.prepareStatement("DELETE FROM sniffresult WHERE sniffdate < ?");
            stmt.setTimestamp(1,  new java.sql.Timestamp(date.getTime()));
            stmt.execute();
            //log.trace("Addition to notes by user " + note.getUser().getUsername());
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            //log.error("Addition of new comment failed " + e.getLocalizedMessage());
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void deleteSniffResultForReferer(String referer) {
        PreparedStatement stmt = null;
        Connection con = getConnection();
        try {
            stmt = con.prepareStatement("DELETE FROM sniffresult WHERE referer = ?");
            stmt.setString(1,  referer);
            stmt.execute();
            //log.trace("Addition to notes by user " + note.getUser().getUsername());
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            //log.error("Addition of new comment failed " + e.getLocalizedMessage());
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
