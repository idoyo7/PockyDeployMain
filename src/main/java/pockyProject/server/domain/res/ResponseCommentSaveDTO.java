package pockyProject.server.domain.res;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ResponseCommentSaveDTO {

    private String commentUid;

    private String feedUid;

    private String userUid;

    private String writer;


    private String writeImage;

    private String content;

    private Integer likeCount;


    private LocalDateTime createdAt;


    private LocalDateTime updatedAt;


    private LocalDateTime deletedAt;

}
