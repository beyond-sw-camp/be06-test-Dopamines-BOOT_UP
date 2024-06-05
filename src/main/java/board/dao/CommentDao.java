package board.dao;

import board.response.CommentDto;
import com.zaxxer.hikari.HikariDataSource;
import config.DataSourceConfig;
import member.request.PostMemberReq;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDao {
    HikariDataSource dataSourceConfig;

    public CommentDao() {
        dataSourceConfig = DataSourceConfig.getInstance();
    }

    public List<CommentDto> readAll(Integer idx) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            connection = dataSourceConfig.getConnection();
            String sql = """
                    SELECT fc.idx, fc.content, fc.author, fc.created_at, fc.updated_at, fc.user_idx, user.nickname, count(*) cnt
                    FROM free_comment AS fc
                    INNER JOIN free_board AS fb
                    ON fb.idx = ?
                    INNER JOIN user
                    ON fc.user_idx = user.idx
                    INNER JOIN free_comment_like AS fcl
                    ON fc.idx = fcl.free_comment_idx
                    GROUP BY fc.idx
                    """;
//            pstmt = connection.prepareStatement("SELECT * FROM free_comment WHERE free_board_idx=?");

            pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, idx);

            rs = pstmt.executeQuery();
            List<CommentDto> result = new ArrayList<>();

            while (rs.next()) {
                CommentDto getCommentDto = new CommentDto(
                        rs.getLong("idx"),
                        rs.getString("content"),
                        rs.getString("nickname"),
                        (rs.getTimestamp("created_at")).toLocalDateTime(),
                        (rs.getTimestamp("updated_at")).toLocalDateTime(),
                        rs.getInt("cnt"),
                        rs.getLong("user_idx"));
                result.add(getCommentDto);
            }

            return result;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException sqlEx) {
                } // ignore
                pstmt = null;
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException sqlEx) {
                } // ignore
                connection = null;
            }

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                } // ignore
                rs = null;
            }
        }
    }
}