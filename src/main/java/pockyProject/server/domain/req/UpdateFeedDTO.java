package pockyProject.server.domain.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import pockyProject.server.entity.feedEntity.FeedEntity;
import java.util.List;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateFeedDTO {

    private  String feedUid;

    private String userUid;

    private   String title;

    private   String content;

    private String qrImage;

    private   int  LikeCount;

    private Integer menuImage;

    private LocalDateTime updateDate;


    public UpdateFeedDTO(String feedUid,String userUid, String title,String content, String  qrImage,int menuImage, int likeCount ) {
        this.feedUid = feedUid;
        this.userUid= userUid;
        this.title = title;
        this.menuImage = menuImage;
        this.LikeCount = likeCount;
        this.content = content;
        this.qrImage = qrImage;
    }


    public  UpdateFeedDTO UpdateDTOFeed(FeedEntity feed) {
        return new UpdateFeedDTO (

                this.feedUid = feed.getFeedUid(),
                this.userUid=feed.getUser().getUserUid(),
                this.content = feed.getContent(),
                this.title = feed.getTitle(),
                this.qrImage = feed.getQrImage(),
                this.LikeCount = feed.getLikeCount(),
                this.menuImage=feed.getMenuImage());


    }
}
