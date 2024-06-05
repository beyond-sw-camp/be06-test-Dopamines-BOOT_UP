package board.response;

import java.time.LocalDateTime;

public class RecommentDto {
    Long reCommentIdx;
    String content;
    String author;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    Integer reCommentLikes;
}
