package pockyProject.server.entity.feedEntity;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import pockyProject.server.domain.req.UpdateFeedDTO;
import pockyProject.server.domain.res.ResponseCommentSaveDTO;
import pockyProject.server.domain.res.ResponseFeedSaveDTO;
import pockyProject.server.entity.UserEntity;
import java.util.List;
import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@Builder
@Slf4j
@Table(name = "feed")
@AllArgsConstructor
@NoArgsConstructor
public class FeedEntity {

    @Id
    @Column(name = "feeduid")
    private String feedUid;

    @ManyToOne
    @JoinColumn(name = "useruid")
    private UserEntity user;


    private String title;


    private String content;



    @Column(name = "qrimage")
    private String qrImage;

    @Column(name = "menuimage")
    private  Integer  menuImage;

    @Column(name = "likecount")
    private Integer likeCount;



    @Column(name = "createdat")
    private LocalDateTime createdAt;
    @Column(name = "updatedat")
    private LocalDateTime updatedAt;


    @Column(name = "deletedat")
    private LocalDateTime deletedAt;





    public static FeedEntity FeedToEntity(ResponseFeedSaveDTO feed ) {
        UserEntity userEntity=new UserEntity();
        userEntity.setUserUid(feed.getUserUid());
        return FeedEntity.builder()
                .feedUid(feed.getFeedUid())
                .user(userEntity)
                .title(feed.getTitle())
                .content(feed.getContent())
                .qrImage(feed.getQrImage())
                .menuImage(feed.getMenuImage())
                .likeCount(feed.getLikeCount())
                .createdAt(LocalDateTime.now())
                .build();
    }


    public FeedEntity UpdateFeed(UpdateFeedDTO feed) {
        UserEntity userId=new UserEntity();
        return FeedEntity.builder()
                .feedUid(feed.getFeedUid())
                .user(userId)
                .title(feed.getTitle())
                .content(feed.getContent())
                .qrImage(feed.getQrImage())
                .likeCount(feed.getLikeCount())
                .updatedAt(LocalDateTime.now())
                .menuImage(feed.getMenuImage())
                .build();

    }


}

