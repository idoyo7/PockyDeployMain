package pockyProject.server.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pockyProject.server.dao.FeedDAO;
import pockyProject.server.domain.req.RequestFeedDTO;
import pockyProject.server.domain.req.UpdateFeedDTO;
import pockyProject.server.domain.res.ResponseFeedSaveDTO;
import pockyProject.server.entity.feedEntity.FeedEntity;

import static pockyProject.server.entity.feedEntity.FeedEntity.FeedToEntity;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class FeedServiceImpl implements FeedService {

    private  final FeedDAO  feedDAO;



    @Override
    public void FeedSave(ResponseFeedSaveDTO responseFeedSaveDTO) {

        FeedEntity feedEntity =new FeedEntity();
        feedEntity=FeedToEntity(responseFeedSaveDTO);

        feedDAO.insertFeed(feedEntity);
    }

    @Override
    public List<RequestFeedDTO> GetFeed(String userId) {

    //  log.info(feedDAO.getFeedAll(userId).toString());
      return  feedDAO.getFeedById(userId);

    }

    @Override
    public UpdateFeedDTO UpdateFeed(String id, UpdateFeedDTO updateFeedDTO) {
        FeedEntity DTO=new FeedEntity();
        FeedEntity updateFeed = DTO.UpdateFeed(updateFeedDTO);
        log.info(updateFeed.getUser().getUserUid());
        feedDAO.insertFeed(updateFeed);
        return  updateFeedDTO;
    }

    @Override
    public void DeleteFeed(String userUid) {
        feedDAO.deleteFeed(userUid);
    }

    @Override
    public List<RequestFeedDTO> GetFeedAll(){
        List<FeedEntity> feed=feedDAO.getFeedAll();
        List<RequestFeedDTO> result= feed.stream()
                .map(o->new RequestFeedDTO().requestFeedDTO(o))
                .collect(Collectors.toList());


        return  result;
    }
}
