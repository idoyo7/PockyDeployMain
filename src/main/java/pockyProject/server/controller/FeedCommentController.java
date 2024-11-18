package pockyProject.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pockyProject.server.domain.req.RequestCommentDTO;
import pockyProject.server.domain.req.UpdateCommentDTO;
import pockyProject.server.domain.res.ResponseCommentSaveDTO;
import pockyProject.server.service.CommentService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FeedCommentController {

    private final CommentService commentService;

    @PostMapping("/save/comment/{feeduid}")
    public void saveComment(@PathVariable("feeduid") String feeduid, @RequestBody ResponseCommentSaveDTO res) {

        commentService.addComment(res);
    }



    @GetMapping("/get/comment/{feedUid}")
    public List<RequestCommentDTO> getAllComments(@PathVariable("feedUid") String feedUid) {

        return commentService.getCommentAll(feedUid);

    }
    @PutMapping("/update/comment/{commentUid}")
    public UpdateCommentDTO updateComment(@PathVariable("commentUid") String commentUid, @RequestBody UpdateCommentDTO res) {

        return commentService.updateComment(commentUid ,res);
    }


    @DeleteMapping("delete/comment/{commentuid}")
    public void deleteComment(@PathVariable("commentuid") String commentUid) {

        commentService.deleteComment(commentUid);

    }

}
