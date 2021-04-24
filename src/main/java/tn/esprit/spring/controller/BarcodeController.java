package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.barcode.BarcodeResponse;
import tn.esprit.spring.service.DynamsoftBarcode;
import tn.esprit.spring.service.ZXingBarcode;



@RestController
public class BarcodeController {
	
	
	@Autowired
	 DynamsoftBarcode mDynamsoftBarcode;
	
	@Autowired
     ZXingBarcode mZXingBarcode;
    
    @Autowired
    public BarcodeController(DynamsoftBarcode dynamsoft, ZXingBarcode zxing) 
    {
        mDynamsoftBarcode = dynamsoft;
        mZXingBarcode = zxing;
    }
    
    //http://localhost:9090/SpringMVC/servlet/dynamsoft

   /* @PostMapping(value = "/dynamsoft", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BarcodeResponse getDynamsoft(@RequestPart MultipartFile file) throws Exception {
        return mDynamsoftBarcode.decode(file.getOriginalFilename(), file.getInputStream());
    }
    



    @PostMapping(value = "/zxing"
            , consumes = MediaType.MULTIPART_FORM_DATA_VALUE
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public BarcodeResponse getZXing(@RequestPart MultipartFile file) throws Exception {
        return mZXingBarcode.decode(file.getOriginalFilename(), file.getInputStream());

    }

    */


	
}
