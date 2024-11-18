package pockyProject.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pockyProject.server.dao.CommentDAO;
import pockyProject.server.domain.req.RequestCommentDTO;
import pockyProject.server.domain.res.ResponseCommentSaveDTO;
import pockyProject.server.domain.req.UpdateCommentDTO;
import pockyProject.server.entity.feedEntity.CommentEntity;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentDAO commentDAO;

    @Override
    public void addComment(ResponseCommentSaveDTO comment) {
        CommentEntity commentEntity=new CommentEntity();
        commentEntity=commentEntity.DTOtoCommentEntity(comment);
        commentDAO.saveComment(commentEntity);
    }

    @Override
    public List<RequestCommentDTO> getCommentAll(String feedUid) {

        List<RequestCommentDTO> comments=commentDAO.commentAll(feedUid);

        return comments;
    }

    @Override
    public UpdateCommentDTO updateComment(String commentUid, UpdateCommentDTO comment) {

      if( commentUid!=commentDAO.findCommentById(comment.getCommentUid()))
      {
         throw  new IllegalArgumentException("댓글 정보가 다릅니다 ");
      }

        commentDAO.updateCommentEntity(comment);

        return comment;
    }

    @Override
    public void deleteComment(String commentUid) {

        commentDAO.deleteCommentById(commentUid);

    }
}
