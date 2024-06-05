package board.response;

import java.time.LocalDateTime;
import java.util.List;

public class CommentDto {
    Long commentIdx;
    String content;
    String author;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    Integer commentLikes;
    Long userIdx;
    List<RecommentDto> recomments;

    public CommentDto(Long commentIdx, String content, String author, LocalDateTime createdAt, LocalDateTime updatedAt, Integer commentLikes, List<RecommentDto> recomments) {
        this.commentIdx = commentIdx;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.commentLikes = commentLikes;
        this.recomments = recomments;
    }

    public CommentDto(Long commentIdx, String content, String author, LocalDateTime createdAt, LocalDateTime updatedAt, Integer commentLikes, Long userIdx) {
        this.commentIdx = commentIdx;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.commentLikes = commentLikes;
        this.userIdx = userIdx;
    }

    public Long getCommentIdx() {
        return commentIdx;
    }

    public void setCommentIdx(Long commentIdx) {
        this.commentIdx = commentIdx;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getCommentLikes() {
        return commentLikes;
    }

    public void setCommentLikes(Integer commentLikes) {
        commentLikes = commentLikes;
    }

    public List<RecommentDto> getRecomments() {
        return recomments;
    }

    public void setRecomments(List<RecommentDto> recomments) {
        this.recomments = recomments;
    }

    public Long getUserIdx() {
        return userIdx;
    }

    public void setUserIdx(Long userIdx) {
        this.userIdx = userIdx;
    }
}
