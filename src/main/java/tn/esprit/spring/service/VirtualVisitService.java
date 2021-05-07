package tn.esprit.spring.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.VVrayonImage;
import tn.esprit.spring.repository.FileVvRepository;


@Service
public class VirtualVisitService {
	





  @Autowired
  FileVvRepository fileDBRepository;

  public VVrayonImage store(MultipartFile file) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    VVrayonImage vvwrayomimage = new VVrayonImage(fileName, file.getContentType(), file.getBytes());

    return fileDBRepository.save(vvwrayomimage);
  }

}
