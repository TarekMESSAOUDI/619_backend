package tn.esprit.spring.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import tn.esprit.spring.entity.Bill;
import tn.esprit.spring.entity.PaymentType;
import tn.esprit.spring.repository.BillRepository;
import tn.esprit.spring.repository.OrderRepository;




@Service
public class BillServiceImpl implements IBillService {
	
	@Autowired
	private BillRepository billRepository;
	
	@Autowired 
	private OrderRepository orderRepository;
	
	

	private static final Logger L=LogManager.getLogger(BillServiceImpl.class);
	
	
	@Override
	public Bill addBill(Bill b) {
		// TODO Auto-generated method stub
		return billRepository.save(b);
		
	}

	@Override
	public List<Bill> getAllBill() {
		return (List<Bill>)billRepository.findAll();
	}
	
	@Override
	public void deleteBill(Long idBill) {
		billRepository.deleteById(idBill);
		
	}
	
	@Override
	public Bill updateBill(Bill b) {
		
		return billRepository.save(b);
	}
	
	@Override
	public Optional<Bill> getBill_by_ID(Long idBill) {
		return billRepository.findById(idBill);
	}
	
	
	 @Override
	 public List<Bill> getBill_by_Type(PaymentType paymentType){
	    return billRepository.findByPaymentType(paymentType);
	 }
	
	 
	 @Override
	 public List<Bill> getAllBill_by_Order(Long idOrder) {
		return billRepository.getAllBill_by_Order(idOrder);
	}
	 
	 
	 @Override
		public void modify_type_bill(PaymentType paymentType, Long idBill) {
		Bill b =	billRepository.findById(idBill).get();
		b.setPaymentType(paymentType);
			billRepository.save(b);
		}
	 
	 @Override
		public String  get_payment_type_by_idBill(Long idBill) {
			
			 return billRepository.get_payment_type_by_idBill(idBill);
		}
	 


	 
//	@Override
//		public void billpdf (Long idBill){
//			try {
//				Bill b = billRepository.getOne(idBill);
//				
//			String file_name="C:\\Users\\lenovo\\Desktop\\Bill\\Bill"+b.getIdBill()+".pdf";
//			Document document=new Document(PageSize.A4,15,15,45,30);
//			
//				PdfWriter.getInstance(document, new FileOutputStream(file_name));
//		
//		 document.open();
//		 document.add(new Paragraph("  "));
//		    document.add(new Paragraph("  "));
//			 Image img=Image.getInstance("C:\\Users\\lenovo\\Desktop\\Bill\\logo.png");
//			 img.setAlignment(Element.ALIGN_LEFT);
//			 img.setIndentationLeft(5);
//			 img.setIndentationRight(5);
//			 img.setSpacingAfter(1);
//			 document.add(img); 
//			 document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------------"));
//		 document.add(new Paragraph("Telephone  :(+216) 98155255   "+"                                                             Adresse :Al Ghazela /Tunis "));
//		 document.add(new Paragraph("Fax          :(+216) 75155255   "+"                                                                 Code Postal :2088  "));
//		 document.add(new Paragraph("Email       :service@consomitounsi.tn  "));
//		 document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------------"));
//		 document.add(new Paragraph(" "));
//		 document.add(new Paragraph(" "));
//		 ////////////////
//
//		 ////////////////////////////
//		 Font font = FontFactory.getFont("Cooper Black", 15, BaseColor.BLUE);
//		 Date aujourdhui = b.getDateBill();
//		 document.add(new Paragraph("Destinataire :   "+b.getOrder().getUser().getIdUser()));
//		 SimpleDateFormat formater = null;
//		 formater = new SimpleDateFormat("dd-MM-yy");
//		
//		 Paragraph adresse=new Paragraph("Adresse : "+b.getOrder().getUser().getAdressUser()+"                                                                                  Date de commande : "+b.getOrder().getDateOrder());
//		 document.add(adresse);
//	
//		 document.add(new Paragraph("Numéro de téléphone :  "+b.getOrder().getUser().getPhoneNumberUser()));
//		 Font mainFont = FontFactory.getFont("Cooper Black",35, BaseColor.BLACK);
//		 Paragraph para=new Paragraph("Bill N° "+b.getIdBill(),mainFont);
//		 para.setAlignment(Element.ALIGN_CENTER);
//		 para.setIndentationLeft(10);
//		 para.setIndentationRight(10);
//		 para.setSpacingAfter(10);
//		 document.add(para);
//		 
//		 
//		
//		 ///////////////////
//		 PdfPTable table = new PdfPTable(4);
//		 PdfPTable table2 = new PdfPTable(3);
//		  Font tableHeader = FontFactory.getFont("Arial", 10, BaseColor.BLACK);
//		    Font tableBody = FontFactory.getFont("Arial", 9, BaseColor.BLACK);
//		 PdfPCell name = new PdfPCell(new Paragraph("Product Number", tableHeader));
//		    name.setBorderColor(BaseColor.BLACK);
//		    name.setPaddingLeft(10);
//		    name.setHorizontalAlignment(Element.ALIGN_CENTER);
//		    name.setVerticalAlignment(Element.ALIGN_CENTER);
//		    name.setBackgroundColor(BaseColor.LIGHT_GRAY);
//		    name.setExtraParagraphSpace(5f);
//		    table.addCell(name);
//		    
//		    PdfPCell nameProduit = new PdfPCell(new Paragraph("Order State", tableHeader));
//		    nameProduit.setBorderColor(BaseColor.BLACK);
//		    nameProduit.setPaddingLeft(10);
//		    nameProduit.setHorizontalAlignment(Element.ALIGN_CENTER);
//		    nameProduit.setVerticalAlignment(Element.ALIGN_CENTER);
//		    nameProduit.setBackgroundColor(BaseColor.LIGHT_GRAY);
//		    nameProduit.setExtraParagraphSpace(5f);
//		    table.addCell(nameProduit);
//		     
//		    PdfPCell Prix = new PdfPCell(new Paragraph("Amount", tableHeader));
//		    Prix.setBorderColor(BaseColor.BLACK);
//		    Prix.setPaddingLeft(10);
//		    Prix.setHorizontalAlignment(Element.ALIGN_CENTER);
//		    Prix.setVerticalAlignment(Element.ALIGN_CENTER);
//		    Prix.setBackgroundColor(BaseColor.LIGHT_GRAY);
//		    Prix.setExtraParagraphSpace(5f);
//		    table.addCell(Prix);
//		    
//		    
//		    PdfPCell Totale = new PdfPCell(new Paragraph("PaymentType", tableHeader));
//		    Totale.setBorderColor(BaseColor.BLACK);
//		    Totale.setPaddingLeft(10);
//		    Totale.setHorizontalAlignment(Element.ALIGN_CENTER);
//		    Totale.setVerticalAlignment(Element.ALIGN_CENTER);
//		    Totale.setBackgroundColor(BaseColor.LIGHT_GRAY);
//		    Totale.setExtraParagraphSpace(5f);
//		    table.addCell(Totale);
//		    
//		    /////////////////////////////
//		    /////////////////////////////
//		    /////////////////////////////
//		    ////////////////////////////
//		   
//		    PdfPCell quantiteval = new PdfPCell(new Paragraph(String.valueOf(b.getOrder().getProductNumberOrder()) , tableHeader));
//	 	    quantiteval.setBorderColor(BaseColor.BLACK);
//	 	    quantiteval.setPaddingLeft(10);
//	 	    quantiteval.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 	    quantiteval.setVerticalAlignment(Element.ALIGN_CENTER);
//	 	    quantiteval.setBackgroundColor(BaseColor.WHITE);
//	 	    quantiteval.setExtraParagraphSpace(5f);
//	 	    table.addCell(quantiteval);
//	 	    
//	 	    
//	 	    PdfPCell produiteval = new PdfPCell(new Paragraph(String.valueOf(b.getOrder().getStateOrder() ), tableHeader));
//	 	    produiteval.setBorderColor(BaseColor.BLACK);
//	 	    produiteval.setPaddingLeft(10);
//	 	    produiteval.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 	    produiteval.setVerticalAlignment(Element.ALIGN_CENTER);
//	 	    produiteval.setBackgroundColor(BaseColor.WHITE);
//	 	    produiteval.setExtraParagraphSpace(5f);
//	 	    table.addCell(produiteval);
//	 	    
//	 	    
//	 	    PdfPCell prixval = new PdfPCell(new Paragraph(String.valueOf(b.getOrder().getAmountOrder() ), tableHeader));
//	 	    prixval.setBorderColor(BaseColor.BLACK);
//	 	    prixval.setPaddingLeft(10);
//	 	    prixval.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 	    prixval.setVerticalAlignment(Element.ALIGN_CENTER);
//	 	    prixval.setBackgroundColor(BaseColor.WHITE);
//	 	    prixval.setExtraParagraphSpace(5f);
//	 	    table.addCell(prixval);
//	 	    
//	 	    PdfPCell Totaleval = new PdfPCell(new Paragraph(String.valueOf(b.getOrder().getPaymentType()), tableHeader));
//	 	    Totaleval.setBorderColor(BaseColor.BLACK);
//	 	    Totaleval.setPaddingLeft(10);
//	 	    Totaleval.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 	    Totaleval.setVerticalAlignment(Element.ALIGN_CENTER);
//	 	    Totaleval.setBackgroundColor(BaseColor.WHITE);
//	 	    Totaleval.setExtraParagraphSpace(5f);
//	 	    table.addCell(Totaleval);
//		 	    
//		 	    
//		 	
//		 	    
//			
//		    
//		    
//		    
//		    
//		    	   
//		    document.add(table);
//		    
//		    
//		    document.add(new Paragraph("  "));
//		    
//		    document.add(table2);
//		    document.add(new Paragraph("  "));
//		    document.add(new Paragraph("  "));
//		    
//			 document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------------"));
//			 
//		 
//		 document.close();
//			} catch (FileNotFoundException | DocumentException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (MalformedURLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//
//	
//	
//
//	
//
//}

	 
	 
	@Override
		public void billpdf (Long idBill){
			try {
				Bill b = billRepository.getOne(idBill);
				
			String file_name="C:\\Users\\lenovo\\Desktop\\Bill\\Bill"+b.getIdBill()+".pdf";
			Document document=new Document(PageSize.A4,15,15,45,30);
			
				PdfWriter.getInstance(document, new FileOutputStream(file_name));
		
		 document.open();
		 document.add(new Paragraph("  "));
		    document.add(new Paragraph("  "));
			 Image img=Image.getInstance("C:\\Users\\lenovo\\Desktop\\Bill\\logo.png");
			 img.setAlignment(Element.ALIGN_LEFT);
			 img.setIndentationLeft(5);
			 img.setIndentationRight(5);
			 img.setSpacingAfter(1);
			 document.add(img); 
			 document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------------"));
		 document.add(new Paragraph("Telephone  :(+216) 98155255   "+"                                                             Adresse :Al Ghazela /Tunis "));
		 document.add(new Paragraph("Fax          :(+216) 75155255   "+"                                                                 Code Postal :2088  "));
		 document.add(new Paragraph("Email       :service@consomitounsi.tn  "));
		 document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------------"));
		 document.add(new Paragraph(" "));
		 document.add(new Paragraph(" "));
		 ////////////////

		 ////////////////////////////
		 Font font = FontFactory.getFont("Cooper Black", 15, BaseColor.BLUE);
		 Date aujourdhui = b.getDateBill();
		 document.add(new Paragraph("Destinataire :   "+b.getOrder().getUser().getIdUser()));
		 SimpleDateFormat formater = null;
		 formater = new SimpleDateFormat("dd-MM-yy");
		
		 Paragraph adresse=new Paragraph("Adresse : "+b.getOrder().getUser().getAdressUser()+"                                                                                  Date de commande : "+b.getOrder().getDateOrder());
		 document.add(adresse);
	
		 document.add(new Paragraph("Numéro de téléphone :  "+b.getOrder().getUser().getPhoneNumberUser()));
		 Font mainFont = FontFactory.getFont("Cooper Black",35, BaseColor.BLACK);
		 Paragraph para=new Paragraph("Bill N° "+b.getIdBill(),mainFont);
		 para.setAlignment(Element.ALIGN_CENTER);
		 para.setIndentationLeft(10);
		 para.setIndentationRight(10);
		 para.setSpacingAfter(10);
		 document.add(para);
		 
		 
		
		 ///////////////////
		 PdfPTable table = new PdfPTable(4);
		 PdfPTable table2 = new PdfPTable(3);
		  Font tableHeader = FontFactory.getFont("Arial", 10, BaseColor.BLACK);
		    Font tableBody = FontFactory.getFont("Arial", 9, BaseColor.BLACK);
		 PdfPCell name = new PdfPCell(new Paragraph("Product Number", tableHeader));
		    name.setBorderColor(BaseColor.BLACK);
		    name.setPaddingLeft(10);
		    name.setHorizontalAlignment(Element.ALIGN_CENTER);
		    name.setVerticalAlignment(Element.ALIGN_CENTER);
		    name.setBackgroundColor(BaseColor.LIGHT_GRAY);
		    name.setExtraParagraphSpace(5f);
		    table.addCell(name);
		    
		    PdfPCell nameProduit = new PdfPCell(new Paragraph("Order State", tableHeader));
		    nameProduit.setBorderColor(BaseColor.BLACK);
		    nameProduit.setPaddingLeft(10);
		    nameProduit.setHorizontalAlignment(Element.ALIGN_CENTER);
		    nameProduit.setVerticalAlignment(Element.ALIGN_CENTER);
		    nameProduit.setBackgroundColor(BaseColor.LIGHT_GRAY);
		    nameProduit.setExtraParagraphSpace(5f);
		    table.addCell(nameProduit);
		     
		    PdfPCell Prix = new PdfPCell(new Paragraph("Amount", tableHeader));
		    Prix.setBorderColor(BaseColor.BLACK);
		    Prix.setPaddingLeft(10);
		    Prix.setHorizontalAlignment(Element.ALIGN_CENTER);
		    Prix.setVerticalAlignment(Element.ALIGN_CENTER);
		    Prix.setBackgroundColor(BaseColor.LIGHT_GRAY);
		    Prix.setExtraParagraphSpace(5f);
		    table.addCell(Prix);
		    
		    
		    PdfPCell Totale = new PdfPCell(new Paragraph("PaymentType", tableHeader));
		    Totale.setBorderColor(BaseColor.BLACK);
		    Totale.setPaddingLeft(10);
		    Totale.setHorizontalAlignment(Element.ALIGN_CENTER);
		    Totale.setVerticalAlignment(Element.ALIGN_CENTER);
		    Totale.setBackgroundColor(BaseColor.LIGHT_GRAY);
		    Totale.setExtraParagraphSpace(5f);
		    table.addCell(Totale);
		    
		    /////////////////////////////
		    /////////////////////////////
		    /////////////////////////////
		    ////////////////////////////
		   
		    PdfPCell quantiteval = new PdfPCell(new Paragraph(String.valueOf(b.getOrder().getProductNumberOrder()) , tableHeader));
	 	    quantiteval.setBorderColor(BaseColor.BLACK);
	 	    quantiteval.setPaddingLeft(10);
	 	    quantiteval.setHorizontalAlignment(Element.ALIGN_CENTER);
	 	    quantiteval.setVerticalAlignment(Element.ALIGN_CENTER);
	 	    quantiteval.setBackgroundColor(BaseColor.WHITE);
	 	    quantiteval.setExtraParagraphSpace(5f);
	 	    table.addCell(quantiteval);
	 	    
	 	    
	 	    PdfPCell produiteval = new PdfPCell(new Paragraph(String.valueOf(b.getOrder().getStateOrder() ), tableHeader));
	 	    produiteval.setBorderColor(BaseColor.BLACK);
	 	    produiteval.setPaddingLeft(10);
	 	    produiteval.setHorizontalAlignment(Element.ALIGN_CENTER);
	 	    produiteval.setVerticalAlignment(Element.ALIGN_CENTER);
	 	    produiteval.setBackgroundColor(BaseColor.WHITE);
	 	    produiteval.setExtraParagraphSpace(5f);
	 	    table.addCell(produiteval);
	 	    
	 	    
	 	    PdfPCell prixval = new PdfPCell(new Paragraph(String.valueOf(b.getOrder().getAmountOrder() ), tableHeader));
	 	    prixval.setBorderColor(BaseColor.BLACK);
	 	    prixval.setPaddingLeft(10);
	 	    prixval.setHorizontalAlignment(Element.ALIGN_CENTER);
	 	    prixval.setVerticalAlignment(Element.ALIGN_CENTER);
	 	    prixval.setBackgroundColor(BaseColor.WHITE);
	 	    prixval.setExtraParagraphSpace(5f);
	 	    table.addCell(prixval);
	 	    
	 	    PdfPCell Totaleval = new PdfPCell(new Paragraph(String.valueOf(b.getOrder().getPaymentType()), tableHeader));
	 	    Totaleval.setBorderColor(BaseColor.BLACK);
	 	    Totaleval.setPaddingLeft(10);
	 	    Totaleval.setHorizontalAlignment(Element.ALIGN_CENTER);
	 	    Totaleval.setVerticalAlignment(Element.ALIGN_CENTER);
	 	    Totaleval.setBackgroundColor(BaseColor.WHITE);
	 	    Totaleval.setExtraParagraphSpace(5f);
	 	    table.addCell(Totaleval);
		 	    
		 	    
		 	
		 	    
			
		    
		    
		    
		    
		    	   
		    document.add(table);
		    
		    
		    document.add(new Paragraph("  "));
		    
		    document.add(table2);
		    document.add(new Paragraph("  "));
		    document.add(new Paragraph("  "));
		    
			 document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------------"));
			 
		 
		 document.close();
			} catch (FileNotFoundException | DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	
	

	

}

