package board.response;

import java.time.LocalDateTime;
import java.util.List;

public class PostsDtoResponse {
    Long postIdx ;
    String title;
    String content;
    String author;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    Integer postLikes;

    List<CommentDto> comments;
}
