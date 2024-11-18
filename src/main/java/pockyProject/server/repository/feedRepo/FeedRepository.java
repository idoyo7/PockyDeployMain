package pockyProject.server.repository.feedRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pockyProject.server.domain.req.RequestFeedDTO;
import pockyProject.server.domain.req.UpdateFeedDTO;
import pockyProject.server.entity.feedEntity.FeedEntity;
import java.util.List;
@Repository
public interface FeedRepository extends JpaRepository<FeedEntity,String> {

    @Query("select new pockyProject.server.domain.req.RequestFeedDTO(f.feedUid,f.user.userUid,f.title,f.content,f.qrImage,f.likeCount,f.menuImage) from FeedEntity f where f.user.userUid=:userUid" )
    List<RequestFeedDTO> findAllFeedBy(@Param("userUid") String userUid);



    @Query("select new  pockyProject.server.domain.req.UpdateFeedDTO(T.feedUid,T.user.userUid,T.title, T.content,T.qrImage,T.likeCount,T.menuImage) from FeedEntity T where T.feedUid=:feeUid")
    List<UpdateFeedDTO> UpdateFeedBy(@Param("feeUid") String feeUid);

}
