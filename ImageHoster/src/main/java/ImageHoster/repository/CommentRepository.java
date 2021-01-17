package ImageHoster.repository;

import ImageHoster.model.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class CommentRepository {
    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;

    public List<Comment> commentsByImageId(Integer imageId) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Comment> comments = em.createQuery("SELECT c from Comment c WHERE c.image_id = : imageId", Comment.class);
        comments.setParameter("imageId", imageId);

        return comments.getResultList();
    }

    // This method used to add new comment
    // This returns comment object
    public Comment addComment(Comment comment) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();

        try {
            entityTransaction.begin();
            em.persist(comment);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        }

        return comment;
    }

}
