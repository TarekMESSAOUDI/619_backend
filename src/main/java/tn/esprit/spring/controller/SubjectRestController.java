package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Subject;
import tn.esprit.spring.repository.ISubjectRepository;
import tn.esprit.spring.service.ISubjectService;

@RestController
public class SubjectRestController {
	
	@Autowired
	ISubjectService ss;
	
	@Autowired
	ISubjectRepository sr;
	
		// http://localhost:9091/SpringMVC/servlet/add-subject
		@PostMapping("/add-subject")
		@ResponseBody
		public String addSubject(@RequestBody Subject sub) {
		return ss.addSubject(sub);
		}

		// http://localhost:9091/SpringMVC/servlet/delete-subject/{subject-id}
		@DeleteMapping("/delete-subject/{subject-id}")
		@ResponseBody
		public void deleteSubject(@PathVariable("subject-id") int subjectId) {
		ss.deleteSubject(subjectId);
		}
				
		// http://localhost:9091/SpringMVC/servlet/update-subject
		@PutMapping("/update-subject")
		@ResponseBody
		public Subject updateSubject(@RequestBody Subject sub) {
		return ss.updateSubject(sub);
		}

		// http://localhost:9091/SpringMVC/servlet/retrieve-all-subjects
		@GetMapping("/retrieve-all-subjects")
		@ResponseBody
		public List<Subject> getSubject() {
		List<Subject> list = ss.retrieveAllSubject();
		return list;
		}
					
		// http://localhost:9091/SpringMVC/servlet/retrieve-subject-by-id/{subject-id}
		@GetMapping("/retrieve-subject-by-id/{subject-id}")
		@ResponseBody
		public Optional<Subject> retrieveSubjectById(@PathVariable("subject-id") int subjectId) {
		return ss.retrieveSubjectById(subjectId);
		}
		
		// http://localhost:9091/SpringMVC/servlet/retrieve-subject-by-title/{subject-title}
		@GetMapping("/retrieve-subject-by-title/{subject-title}")
		@ResponseBody
		public List<Subject> retrieveSubjectByTitle(@PathVariable("subject-title") String titleSubject) {
		return ss.retrieveSubjectByTitle(titleSubject);
		}
					
		// http://localhost:9091/SpringMVC/servlet/retrieve-subject-by-starsgreater/{subject-stars}
		@GetMapping("/retrieve-subject-by-starsgreater/{subject-stars}")
		@ResponseBody
		public List<Subject> retrieveSubjectByStars(@PathVariable("subject-stars") float starsNumberSubject) {
		return ss.retrieveSubjectByStars(starsNumberSubject);
		}
					
		// http://localhost:9091/SpringMVC/servlet/retrieve-moy-stars-subject
		@GetMapping("/retrieve-moy-by-stars-subject")
		@ResponseBody
		public float retrieveMoyStarsSubject() {
		return sr.retrievemoySubjectByStars();
		}
					
		// http://localhost:9091/SpringMVC/servlet/retrieve-max-stars-subject
		@GetMapping("/retrieve-max-stars-subject")
		@ResponseBody
		public float retrieveMaxStarsSubject() {
		return sr.retrievemaxSubjectByStars();
		}
					
		// http://localhost:9091/SpringMVC/servlet/retrieve-min-stars-subject
		@GetMapping("/retrieve-min-stars-subject")
		@ResponseBody
		public float retrieveMinStarsSubject() {
		return sr.retrieveminSubjectByStars();
		}
					
		// http://localhost:9091/SpringMVC/servlet/retrieve-subject-by-starsless/{subject-starsless}
		@GetMapping("/retrieve-subject-by-starsless/{subject-starsless}")
		@ResponseBody
		public List<Subject> retrieveSubjectByStarsless(@PathVariable("subject-starsless") float starsNumberSubject) {
		return ss.retrieveSubjectByStarsless(starsNumberSubject);
		}

}
