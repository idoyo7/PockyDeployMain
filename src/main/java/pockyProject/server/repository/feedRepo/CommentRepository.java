package pockyProject.server.repository.feedRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pockyProject.server.domain.req.RequestCommentDTO;
import pockyProject.server.entity.feedEntity.CommentEntity;

import java.util.List;
@Repository
public interface CommentRepository  extends JpaRepository<CommentEntity, String> {


    @Query("select new pockyProject.server.domain.req.RequestCommentDTO(f.commentUid,f.userEntity.userUid,f.feedEntity.feedUid,f.writer,f.writerImage,f.content,f.likeCount) from CommentEntity f where f.feedEntity.feedUid=:feedUid order by f.createdAt desc" )
    List<RequestCommentDTO> FeedUidOrderBycreatedatAsc(@Param("feedUid") String feedUid);



}
