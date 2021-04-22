package tn.esprit.spring.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.ImageUser;
import tn.esprit.spring.response.ResponseMessage;
import tn.esprit.spring.service.IImageUserService;
import tn.esprit.spring.service.ImageUserServiceImpl;

@RestController
public class ImageUserRestController {
	
	@Autowired
	private ImageUserServiceImpl usi;
	  
	@Autowired
	IImageUserService ius;
	
		// http://localhost:9091/SpringMVC/servlet/uploaded
		@PostMapping("/uploaded")
		public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";
	    try {
	    usi.addImage(file);
	    message = "Uploaded the file successfully: " + file.getOriginalFilename();
	    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	    }catch (Exception e) {
	    message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	    }
		}
	  
		// http://localhost:9091/SpringMVC/servlet/affect-image-to-user
		@PostMapping("/affect-image-to-user/{idimage}/{iduser}")
		@ResponseBody
		public void affectationImageToUser(@PathVariable("idimage") int idimage,@PathVariable("iduser")int iduser) throws IOException{
		usi.affectationImageToUser(idimage, iduser);
		}
		
		// http://localhost:9091/SpringMVC/servlet/retreive-all-image
		@GetMapping ("/retreive-all-image")
		@ResponseBody
		public Iterable<ImageUser> retreiveAllImage(){
			return ius.retreiveAllImage();
		}
}
