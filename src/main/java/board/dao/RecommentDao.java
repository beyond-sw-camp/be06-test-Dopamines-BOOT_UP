package board.dao;

import board.response.RecommentDto;
import com.zaxxer.hikari.HikariDataSource;
import config.DataSourceConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class RecommentDao {
    HikariDataSource dataSourceConfig;

    public RecommentDao(){
        dataSourceConfig = DataSourceConfig.getInstance();
    }

    public List<RecommentDto> readAll(Long idx) { // 댓글 id

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            connection = dataSourceConfig.getConnection();
            String sql = """
                     select fr.idx, fr.content, fr.created_at, fr.updated_at, fr.user_idx, user.nickname, user.idx, fc.idx, count(*) cnt 
                     from free_recomment as fr inner join free_comment as fc on fr.free_comment_idx = fc.idx 
                     inner join user on fr.user_idx = user.idx
                    inner join free_recomment_like as frl on fr.idx = frl.free_recomment_idx
                    where fc.idx = ? group by fr.idx
                    """;

            pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1,idx);
            rs = pstmt.executeQuery();

            List<RecommentDto> recommentDtos = new ArrayList<>();

            while (rs.next()) {
                Long reCommentIdx = rs.getLong("idx");
                String content = rs.getString("content");
                String author = rs.getString("nickname");

                Timestamp createTimeStamp = rs.getTimestamp("created_at");
                LocalDateTime createdAt = createTimeStamp.toLocalDateTime();

                Timestamp updatedTimeStamp = rs.getTimestamp("updated_at");
                LocalDateTime updatedAt = updatedTimeStamp.toLocalDateTime();

                Integer likeCnt = rs.getInt("cnt");
                Long userIdx = rs.getLong("user.idx");

                recommentDtos.add(new RecommentDto(reCommentIdx,content,author,createdAt,updatedAt,likeCnt, userIdx));

            }

            return recommentDtos;

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        finally {
            if (rs!=null) {
                try{
                    rs.close();
                }catch(SQLException sqlEx) {}
            }

            if (pstmt != null) {
                try{
                    pstmt.close();
                }catch(SQLException sqlEx) {}
            }

            if (connection != null) {
                try{
                    connection.close();
                }catch(SQLException sqlEx) {}
            }
        }
    }
}
