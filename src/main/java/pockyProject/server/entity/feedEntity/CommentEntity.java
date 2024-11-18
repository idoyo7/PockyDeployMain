package pockyProject.server.entity.feedEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pockyProject.server.domain.req.UpdateCommentDTO;
import pockyProject.server.domain.req.UpdateFeedDTO;
import pockyProject.server.domain.res.ResponseCommentSaveDTO;
import pockyProject.server.entity.UserEntity;

import java.time.LocalDateTime;
@AllArgsConstructor
@Entity
@Table(name = "comment")
@Getter
@Builder
@NoArgsConstructor
public class CommentEntity {
        @Id
        @Column(name = "commentuid")
        private String commentUid;


        @ManyToOne
        @JoinColumn(name = "feeduid")
        private FeedEntity feedEntity;

        @ManyToOne
        @JoinColumn(name = "useruid")
        private UserEntity userEntity;

        private String writer;


        @Column(name = "writerimage")
        private String writerImage;


        private String content;

        @Column(name = "likecount")
        private Integer likeCount;

        @Column (name = "createdat")
        private LocalDateTime createdAt;

        @Column(name = "updatedat")
        private  LocalDateTime updatedAt;

        @Column(name = "deletedat")
        private  LocalDateTime deletedAt;


        public CommentEntity DTOtoCommentEntity(ResponseCommentSaveDTO commentDto ) {

                UserEntity user=new UserEntity();
                user.setUserUid(commentDto.getUserUid());
                FeedEntity feed=new FeedEntity();
                feed.setFeedUid(commentDto.getFeedUid());
                return CommentEntity.builder()
                        .commentUid(commentDto.getCommentUid())   // commentUid 설정
                        .feedEntity(feed)         // feedUid 설정
                        .userEntity(user)                          // userUid 대신 실제 UserEntity 사용
                        .writer(commentDto.getWriter())           // writer 설정
                        .writerImage(commentDto.getWriteImage())   // writeImage 설정
                        .content(commentDto.getContent())          // content 설정
                        .likeCount(commentDto.getLikeCount())      // likeCount 설정
                        .createdAt(LocalDateTime.now()) // createdAt 설정 (null 처리)
                        .updatedAt(commentDto.getUpdatedAt()) // updatedAt 설정 (null 처리)
                        .deletedAt(commentDto.getDeletedAt())      // deletedAt 설정
                        .build();


        }




        public CommentEntity UpdateCommentToEntity(UpdateCommentDTO comment) {
                return CommentEntity.builder()
                        .commentUid(comment.getCommentUid())
                        .feedEntity(feedEntity)
                        .userEntity(userEntity)
                        .writer(comment.getWriter())
                        .writerImage(comment.getWriteImage())
                        .content(comment.getContent())
                        .likeCount(comment.getLikeCount())
                        .updatedAt(LocalDateTime.now())
                        .build();



        }
}
