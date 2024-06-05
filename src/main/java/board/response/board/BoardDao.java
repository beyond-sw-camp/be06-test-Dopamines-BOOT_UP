package board.response.board;

import board.response.PostsDtoResponse;
import com.zaxxer.hikari.HikariDataSource;
import config.DataSourceConfig;

import java.sql.*;
import java.time.LocalDateTime;

public class BoardDao {

    HikariDataSource  dataSourceConfig;

    private Connection connection;

    public BoardDao() {
        dataSourceConfig = DataSourceConfig.getInstance();
    }

    public PostsDtoResponse readPosts(Long idx) {
//        System.out.println("DAO 들어왔니?");
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
//        String query = "SELECT * FROM free_board";
        PostsDtoResponse posts = null;
        try{
            connection = dataSourceConfig.getConnection();
            pstmt = connection.prepareStatement("SELECT * FROM free_board where idx = " + idx );
            rs = pstmt.executeQuery();
            rs.next();
            long index = rs.getLong("idx");
//            System.out.println(index);
            String title = rs.getString("title");
//            System.out.println(title);
            String content = rs.getString("content");
            String author = rs.getString("author");
            Timestamp createTimeStamp = rs.getTimestamp("created_at");
            LocalDateTime createdAt = createTimeStamp.toLocalDateTime();
            Timestamp updatedTimeStamp = rs.getTimestamp("updated_at");
            LocalDateTime updatedAt = updatedTimeStamp.toLocalDateTime();
//                    Integer postLikes = rs.getInt("")
            posts = new PostsDtoResponse(index, title, content, author, createdAt, updatedAt);

                return posts;
            } catch (SQLException e) {
            throw new RuntimeException(e);
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
