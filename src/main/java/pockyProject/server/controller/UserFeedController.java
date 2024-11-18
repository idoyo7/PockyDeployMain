package pockyProject.server.controller;

import lombok.RequiredArgsConstructor;


import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pockyProject.server.domain.req.RequestFeedDTO;
import pockyProject.server.domain.req.UpdateFeedDTO;
import pockyProject.server.domain.res.ResponseFeedSaveDTO;
import pockyProject.server.service.FeedService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserFeedController {

    private final FeedService feedService;


   @GetMapping("/test1/hello")
   public String hello1(){
       return "hello2";
   }
    @GetMapping("/test2/hello")
    public String hello2(){
        return "hello3";
    }

    @GetMapping("/test3/hello")
    public String hello3(){
        return "hello4";
    }

    @GetMapping("/test4/hello")
    public String hello4(){
        return "hello5";
    }


    @PostMapping("/save/feed")
    public void feedSave(@RequestBody ResponseFeedSaveDTO responseFeedSaveDTO) throws IOException {
         log.info(responseFeedSaveDTO.getQrImage().toString());
            feedService.FeedSave(responseFeedSaveDTO);
    }

    @GetMapping("/get/feed/{userid}")
    public List<RequestFeedDTO>getFeed(@PathVariable("userid") String userid) {

        log.info(feedService.GetFeed(userid).toString());

        return feedService.GetFeed(userid);
    }

    @GetMapping("/get/feedAll")
    public List<RequestFeedDTO> getFeedUser() {
        return  feedService.GetFeedAll();

    }


    @PutMapping("update/feed/{feedid}")
    public ResponseEntity<UpdateFeedDTO> updateFeed(@PathVariable("feedid")String feedid
            , @RequestBody UpdateFeedDTO updateFeedDTO) {
        UpdateFeedDTO updateFeed=feedService.UpdateFeed(feedid, updateFeedDTO);

        return  ResponseEntity.status(HttpStatus.OK).body(updateFeed);
    }
    @DeleteMapping("delete/feed/{feedid}")
    public void feedDelete(@PathVariable("feedid")String feedid) {
        feedService.DeleteFeed(feedid);


    }

}
