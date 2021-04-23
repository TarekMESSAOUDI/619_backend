package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Subject;
import tn.esprit.spring.repository.ISubjectRepository;

@Service
public class SubjectServiceImpl implements ISubjectService{

	@Autowired
	ISubjectRepository sr;
	
	@Override
	public String addSubject(Subject s) {
		if (sr.existsByTitleSubject(s.getTitleSubject())){
			return "This Subject Exist";
		}else
			return (String) sr.save(s).toString().concat("\n Subject Added Succefully");
	}

	@Override
	public Subject updateSubject(Subject s) {
		return sr.save(s);
	}

	@Override
	public boolean deleteSubject(int id) {
		if (sr.existsById(id)){
			sr.deleteById(id);
			return true;
		}else
		return false;
		
	}

	@Override
	public Optional<Subject> retrieveSubjectById(int id) {
		return sr.findById(id);
	}

	@Override
	public List<Subject> retrieveAllSubject() {
		// TODO Auto-generated method stub
		return (List<Subject>) sr.findAll();
	}

	@Override
	public List<Subject> retrieveSubjectByTitle(String titleSubject) {
		return (List<Subject>) sr.findByTitleSubject(titleSubject);
	}

	@Override
	public List<Subject> retrieveSubjectByStars(float starsNumberSubject) {
		return (List<Subject>) sr.findByStarsNumberSubjectGreaterThan(starsNumberSubject);
	}

	@Override
	public List<Subject> retrieveSubjectByStarsless(float starsNumberSubject) {
		return (List<Subject>) sr.findByStarsNumberSubjectLessThan(starsNumberSubject);
	}

}
