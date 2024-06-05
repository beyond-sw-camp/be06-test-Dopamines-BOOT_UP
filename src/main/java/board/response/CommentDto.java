package board.response;

import java.time.LocalDateTime;
import java.util.List;

public class CommentDto {
    Long commentIdx;
    String content;
    String author;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    Integer CommentLikes;
    List<RecommentDto> recomments;
}
