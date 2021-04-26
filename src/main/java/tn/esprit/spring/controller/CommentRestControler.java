package tn.esprit.spring.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.repository.CommentRepository;
import tn.esprit.spring.service.CommentService;

@RestController
public class CommentRestControler {

	
	@Autowired
	CommentService commentservice;
	@Autowired
	CommentRepository Cr ;
	
	
	// http://localhost:9090/SpringMVC/servlet/retrieve-all-Comments
	@GetMapping("/retrieve-all-Comments")
	@ResponseBody
	public List<Comment> getCommnets() {
	List<Comment> list = commentservice.retrieveAllComments();
	return list;
	}

	//http://localhost:9090/SpringMVC/servlet/retrieve-comment/{comment-id}
		@GetMapping("/retrieve-comment/{comment-id}")
		@ResponseBody
		public Comment retrieveComment(@PathVariable("comment-id") Long commentId) {
		return commentservice.retrieveComment(commentId);
		}
		
		
		/*
		// http://localhost:9090/SpringMVC/servlet/add-comment
		@PostMapping("/add-comment")
		@ResponseBody
		public Comment addComment(@RequestBody Comment c) {
		Comment comment1 = commentservice.addComment(c);
		return comment1;
		}
	*/
	
		//  http://localhost:9090/SpringMVC/servlet/remove-comment/{comment-id}
			@DeleteMapping("/remove-comment/{comment-id}")
			@ResponseBody
			public void removeComment(@PathVariable("comment-id") Long commentId) {
			commentservice.deleteComment(commentId);
			}
			// http://localhost:9090/SpringMVC/servlet/modify-comment
			@PutMapping("/modify-comment")
			@ResponseBody
			public Comment modifyComment(@RequestBody Comment comment) {
			return commentservice.addComment(comment);
			}
	

			
			
			
			// 	http://localhost:9090/SpringMVC/servlet/afficherNbcomment
			@GetMapping("/afficherNbcomment")
			public Long afficherNbCommentaire(){
				return 	commentservice.countNbcomments();
			}
	
			
			
			
			
			
			
			
			/////////////////////////////add comment without bad words//////////////////////////////////////////////
			
			
		//	http://localhost:9090/SpringMVC/servlet/add-comment
			
			@PostMapping("/add-comment")
			public ResponseEntity<?>ajouterCommentaire( @Validated @RequestBody Comment c){
				commentservice.ajouterCommentaire(c);
				return 	ResponseEntity.ok().body(c);
			
			}
			
			
			
			
			@PutMapping("/affecterSubjecttoComment/{ids}/{id}")
			public void affecterSubjecttoComment(@PathVariable("ids") int idSubject, @PathVariable("id") long idComment) {
				commentservice.affecterSubjecttoComment(idSubject, idComment);

			}
			
			
			

			//http://localhost:9090/SpringMVC/servlet/maxdislike
			
			@GetMapping("/maxdislike")
			@PreAuthorize("hasAuthority('ADMINISTRATOR')")
			public int getdislike() {
				 return Cr.MaxDislike();

			}
			
//http://localhost:9090/SpringMVC/servlet/maxlike
			
			@GetMapping("/maxlike")
			@PreAuthorize("hasAuthority('ADMINISTRATOR')")
			public int getlike() {
				 return Cr.Maxlike();

			}
			
//http://localhost:9090/SpringMVC/servlet/Totallikes
			
			@GetMapping("/Totallikes")
			@PreAuthorize("hasAuthority('ADMINISTRATOR')")
			public int totallikes() {
				 return Cr.Totallikes();

			}
			
			
			
			
			
			
			
			
			//http://localhost:9090/SpringMVC/servlet/Getcommentbysubject/{idComment}
			
			@GetMapping("/Getcommentbysubject/{idComment}")
			public String getcommentsofsubject(@PathVariable("idComment") long idComment){
				
				return Cr.Getcommentbysubject(idComment);
				
			}
			
}
