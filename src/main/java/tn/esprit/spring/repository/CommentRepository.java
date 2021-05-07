package tn.esprit.spring.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Comment;



public interface CommentRepository extends CrudRepository<Comment, Long> {
	
	
	
	
	
	
	
	
	@Query("SELECT MAX(c.disLikeNumberComment)FROM Comment c")
	 public int MaxDislike();
	
	
	@Query("SELECT MAX(c.likeNumberComment)FROM Comment c")   
	 public int Maxlike();
	


	@Query("SELECT AVG(c.likeNumberComment)*COUNT(c) FROM Comment c") 
	 public int Totallikes();
	
		
	
	@Query("Select "
			+ "DISTINCT S.descriptionSubject FROM Subject S "
			+ "join S.Comment C "
			+ "where C.idComment=:idComment")
    public String  Getcommentbysubject(@Param("idComment")long idComment);
	
	
	
	
}
