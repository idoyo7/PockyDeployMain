package pockyProject.server.domain.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pockyProject.server.entity.feedEntity.CommentEntity;
import pockyProject.server.entity.feedEntity.FeedEntity;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestCommentDTO {


    private String commentUid;

    private String userUid;

    private String feedUid;



    private String writer;

    private String writeImage;



    private String content;


    private Integer likeCount;



    public RequestCommentDTO requestCommentDTO(CommentEntity comment) {
        this.commentUid=comment.getCommentUid();
        this.feedUid=comment.getFeedEntity().getFeedUid();
        this.userUid = comment.getUserEntity().getUserUid();
        this.content = comment.getContent();
        this.writer=comment.getWriter();
        this.likeCount = comment.getLikeCount();
        this.writeImage = comment.getWriterImage();
        return this;
    }

}
