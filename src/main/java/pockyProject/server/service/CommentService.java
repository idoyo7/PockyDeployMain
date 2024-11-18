package pockyProject.server.service;

import pockyProject.server.domain.req.RequestCommentDTO;
import pockyProject.server.domain.res.ResponseCommentSaveDTO;
import pockyProject.server.domain.req.UpdateCommentDTO;

import java.util.List;



public interface CommentService {



    void addComment(ResponseCommentSaveDTO comment);


    List<RequestCommentDTO> getCommentAll(String feedUid);

    UpdateCommentDTO updateComment(String commentUid ,UpdateCommentDTO comment);


    void deleteComment(String commentUid);
}
