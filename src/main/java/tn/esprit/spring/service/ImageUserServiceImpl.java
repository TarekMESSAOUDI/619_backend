package tn.esprit.spring.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.ImageUser;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.IImageUserRepository;
import tn.esprit.spring.repository.IUserRepository;

@Service
public class ImageUserServiceImpl implements IImageUserService{

	
	@Autowired
	IImageUserRepository iur;
	
	@Autowired
	IUserRepository ur;
	
	 public ImageUser addImage(MultipartFile file) throws IOException {
		    String nameImageUser = StringUtils.cleanPath(file.getOriginalFilename());
		    ImageUser ImageUser = new ImageUser(nameImageUser, file.getContentType(), file.getBytes());

		    return iur.save(ImageUser);
		  }
	 
	 @Override
		public void affectationImageToUser(int idImageUser, int idUser) {
			// TODO Auto-generated method stub
			User user=ur.findById(idUser).get();
			ImageUser imageUser=iur.findById(idImageUser).get();
			imageUser.setUser(user);
			iur.save(imageUser);
}


		@Override
		public Iterable<ImageUser> retreiveAllImage() {
			return iur.findAll();
		}


}
