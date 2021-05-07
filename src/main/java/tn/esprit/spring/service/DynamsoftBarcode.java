package tn.esprit.spring.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.dynamsoft.dbr.BarcodeReader;
import com.dynamsoft.dbr.TextResult;

import tn.esprit.spring.barcode.BarcodeResponse;

@Service
public class DynamsoftBarcode {
	
	


	private static final Logger LOG = LoggerFactory.getLogger(DynamsoftBarcode.class);
    private String license;
    
    public DynamsoftBarcode() {
        // Get license from https://www.dynamsoft.com/CustomerPortal/Portal/Triallicense.aspx
        license = "LICENSE-KEY";
    }
    

    
    public BarcodeResponse decode(String filename, java.io.InputStream inputStream) {

    public BarcodeResponse decode(String filename, java.io.InputStream inputStream) {


        try {
           LOG.info("Decoding barcodes...");

            BarcodeReader barcodeReader = new BarcodeReader();
            barcodeReader.initLicense(license);
            TextResult[] results = barcodeReader.decodeFileInMemory(inputStream, "");
            String[] allResults = null, allFormats = null;
            if (results != null) {
                allResults = new String[results.length];
                allFormats = new String[results.length];
                for (int i = 0; i < results.length; ++i) {
                    allResults[i] = results[i].barcodeText;
                    allFormats[i] = results[i].barcodeFormatString;
                }
            }
            
            if (barcodeReader != null) {
                barcodeReader = null;
            }
            return BarcodeResponse.builder().filename(filename).results(allResults).formats(allFormats).build();
        } catch (Exception ex) {
            LOG.error(ex.getMessage());
            return BarcodeResponse.builder().filename(filename).error(ex.getMessage()).build();
        }
    }

    
    


}


