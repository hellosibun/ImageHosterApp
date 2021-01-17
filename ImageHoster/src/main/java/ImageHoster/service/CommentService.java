package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRespository;

    // Return all comments for specific image
    public List<Comment> getAllCommentByImageId(Integer imageId) {
        return commentRespository.commentsByImageId(imageId);
    }

    // Add comment to any specific image
    public Comment createComment(Comment newComment) {
        return commentRespository.addComment(newComment);
    }
}
