package pockyProject.server.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pockyProject.server.domain.req.RequestFeedDTO;
import pockyProject.server.domain.req.UpdateFeedDTO;
import pockyProject.server.entity.feedEntity.FeedEntity;
import pockyProject.server.repository.feedRepo.FeedRepository;
import java.util.List;
import java.util.Optional;


@Component
@RequiredArgsConstructor
public class FeedDaoImpl implements  FeedDAO{
    private final FeedRepository feedRepository;

    @Override
    public FeedEntity insertFeed(FeedEntity feedEntity) {
      return   feedRepository.save(feedEntity);
    }

    @Override
    public List<FeedEntity> getFeed(RequestFeedDTO requestFeedDTO) {
        return feedRepository.findAll();
    }

    @Override
    public FeedEntity getUserId(String userId) {
        return  feedRepository.findById(userId).orElse(null);
    }

    @Override
    public List<RequestFeedDTO> getFeedById(String userId) {
        return feedRepository.findAllFeedBy(userId);
    }


    @Override
    public List<FeedEntity> getFeedAll() {
        return feedRepository.findAll();
    }

    @Override
    public List<UpdateFeedDTO> updateFeed(String feedId, UpdateFeedDTO updateFeedDTO) {
        return feedRepository.UpdateFeedBy(feedId);
    }

    @Override
    public FeedEntity updateFeed(FeedEntity feedEntity) {
        return  feedRepository.save(feedEntity);
    }

    @Override
    public void deleteFeed(String feedUid) {
        feedRepository.deleteById(feedUid);
    }

}
