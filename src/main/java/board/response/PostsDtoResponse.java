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

    List<board.response.CommentDto> comments;


    public PostsDtoResponse(Long postIdx, String title, String content, String author, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.postIdx = postIdx;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;

    }

    public PostsDtoResponse() {

    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public Integer getPostLikes() {
        return postLikes;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public Long getPostIdx() {
        return postIdx;
    }

    public void setPostIdx(Long postIdx) {
        this.postIdx = postIdx;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setPostLikes(Integer postLikes) {
        this.postLikes = postLikes;
    }

    public void setComments(List<CommentDto> comments) {
        this.comments = comments;
    }
}