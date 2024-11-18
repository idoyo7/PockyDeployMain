package pockyProject.server.domain.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pockyProject.server.entity.feedEntity.FeedEntity;

import java.util.Base64;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class RequestFeedDTO {

    private String feedUid;

    private String userUid;

    private  String title;

    private  String content;

    private String qrImage;


    private  Integer likeCount;

    private  Integer  menuImage;


    public RequestFeedDTO requestFeedDTO(FeedEntity feed) {
        this.feedUid = feed.getFeedUid();
        this.userUid = feed.getUser().getUserUid();
        this.title = feed.getTitle();
        this.content = feed.getContent();
        this.qrImage = feed.getQrImage();
        this.likeCount = feed.getLikeCount();
        this.menuImage = feed.getMenuImage();
        return this;
    }



}
