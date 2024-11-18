package pockyProject.server.dao;

import pockyProject.server.domain.req.RequestFeedDTO;
import pockyProject.server.domain.req.UpdateFeedDTO;
import pockyProject.server.entity.feedEntity.FeedEntity;
import java.util.List;

public interface FeedDAO {


    FeedEntity insertFeed(FeedEntity feedEntity);

    List<FeedEntity> getFeed(RequestFeedDTO requestFeedDTO);


    FeedEntity getUserId(String userId);


    List<RequestFeedDTO> getFeedById(String userId);


    List<FeedEntity> getFeedAll();

    List<UpdateFeedDTO> updateFeed(String feedId,UpdateFeedDTO updateFeedDTO);


    FeedEntity updateFeed(FeedEntity feedEntity);


    void deleteFeed(String FeedUid);
}
