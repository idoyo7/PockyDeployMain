package pockyProject.server.service;


import java.util.List;
import pockyProject.server.domain.req.RequestFeedDTO;
import pockyProject.server.domain.req.UpdateFeedDTO;
import pockyProject.server.domain.res.ResponseFeedSaveDTO;
import pockyProject.server.entity.feedEntity.FeedEntity;

import java.util.Optional;

public interface FeedService {

    void FeedSave(ResponseFeedSaveDTO responseFeedSaveDTO);


    List<RequestFeedDTO> GetFeed(String userUid);


    UpdateFeedDTO UpdateFeed(String userUid, UpdateFeedDTO updateFeedDTO);


    void DeleteFeed(String userUid);

    List<RequestFeedDTO> GetFeedAll();
}
