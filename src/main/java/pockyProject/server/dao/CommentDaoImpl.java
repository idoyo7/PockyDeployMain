package pockyProject.server.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pockyProject.server.domain.req.RequestCommentDTO;
import pockyProject.server.domain.req.UpdateCommentDTO;
import pockyProject.server.entity.feedEntity.CommentEntity;
import pockyProject.server.repository.feedRepo.CommentRepository;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class CommentDaoImpl implements  CommentDAO {

    private final CommentRepository commentRepository;


    @Override
    public void saveComment(CommentEntity comment) {

        commentRepository.save(comment);
    }

    @Override
    public List<RequestCommentDTO> commentAll(String feedUid) {
        return commentRepository.FeedUidOrderBycreatedatAsc(feedUid);
    }

    @Override
    public CommentEntity updateCommentEntity(UpdateCommentDTO updateCommentDTO) {
        CommentEntity comment=new CommentEntity();
        return  commentRepository.save(comment.UpdateCommentToEntity(updateCommentDTO));
    }

    @Override
    public String findCommentById(String commentId) {
        return commentRepository.findById(commentId)
                .map(CommentEntity::getCommentUid)  // CommentEntity에서 commentId를 추출
                .orElse("Comment not found");
    }

    @Override
    public void deleteCommentById(String commentId) {
        commentRepository.deleteById(commentId);
    }
}
