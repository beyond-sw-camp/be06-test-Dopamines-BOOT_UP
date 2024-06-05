package board.response;

import java.time.LocalDateTime;

public class RecommentDto {
    Long reCommentIdx;
    String content;
    String author;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    Integer reCommentLikes;
    Long userIdx;

    public RecommentDto(Long reCommentIdx, String content, String author, LocalDateTime createdAt,
                        LocalDateTime updatedAt,
                        Integer reCommentLikes, Long userIdx) {
        this.reCommentIdx = reCommentIdx;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.reCommentLikes = reCommentLikes;
        this.userIdx = userIdx;
    }

    @Override
    public String toString() {
        return "RecommentDto{" +
                "reCommentIdx=" + reCommentIdx +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", reCommentLikes=" + reCommentLikes +
                ", userIdx=" + userIdx +
                '}';
    }
}
