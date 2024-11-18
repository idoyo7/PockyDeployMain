package pockyProject.server.domain.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pockyProject.server.entity.feedEntity.CommentEntity;
import pockyProject.server.entity.feedEntity.FeedEntity;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCommentDTO {

    private String commentUid;

    private String feedUid;

    private String userUid;

    private String writer;


    private String writeImage;



    private String content;


    private Integer likeCount;


    private LocalDateTime updatedAt;



    public  UpdateCommentDTO UpdateDTOComment(CommentEntity comment) {
        return new UpdateCommentDTO (
                this.commentUid=comment.getCommentUid(),
                this.feedUid = comment.getFeedEntity().getFeedUid(),
                this.userUid=comment.getUserEntity().getUserUid(),
                this.writer=comment.getWriter(),
                this.writeImage=comment.getWriter(),
                this.content = comment.getContent(),
                this.likeCount=comment.getLikeCount(),
                this.updatedAt=LocalDateTime.now()
        );


    }
}
