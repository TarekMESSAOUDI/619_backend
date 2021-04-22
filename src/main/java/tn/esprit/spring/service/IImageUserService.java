package tn.esprit.spring.service;

import tn.esprit.spring.entity.ImageUser;

public interface IImageUserService {
	
	void affectationImageToUser(int idImageUser, int idUser);
	
	public Iterable<ImageUser> retreiveAllImage();

}
