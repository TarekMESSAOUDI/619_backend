package tn.esprit.spring.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

import tn.esprit.spring.entity.Order;
import tn.esprit.spring.entity.PaymentType;
import tn.esprit.spring.repository.BillRepository;
import tn.esprit.spring.repository.OrderRepository;


@Service
public class OrderServiceImpl implements IOrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	private BillRepository billRepository;
	
	

	private static final Logger L=LogManager.getLogger(OrderServiceImpl.class);
	
	
	@Override
	public Order addOrder(Order o) {
		// TODO Auto-generated method stub
		return orderRepository.save(o);
		
	}
	
	@Override
	public Optional<Order> getBill_by_ID(Long idOrder) {
		return orderRepository.findById(idOrder);
	}
	
	@Override
	public Order updateOrder(Order o) {
		
		return orderRepository.save(o);
	}
	
	@Override
	public void deleteOrder(Long idOrder) {
		orderRepository.deleteById(idOrder);
		
	}
	
	@Override
	public List<Order> getAllOrder() {
		return (List<Order>)orderRepository.findAll();
	}
	
	@Override
	 public List<Order> getOrder_by_Type(PaymentType paymentType){
	    return orderRepository.findByPaymentType(paymentType);
	 }
	
	@Override
	public void Pay_By_Card(Long idOrder) {
		orderRepository.Pay_By_Card(idOrder);

	}
	
	@Override
	public void Pay_At_Delivery(Long idOrder) {
		orderRepository.Pay_At_Delivery(idOrder);
	}
	
	
	@Override
	 public List<Order> getAllOrder_by_Client(int idUser) {
		return orderRepository.getAllOrder_by_Client(idUser);
	}
	
	
	
	@Override
	public void orderpdf (Long idOrder){
		try {
			Order o = orderRepository.getOne(idOrder);
			
		String file_name="C:\\Users\\lenovo\\Desktop\\Bill\\Bill"+o.getIdOrder()+".pdf";
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
	 Date aujourdhui = o.getDateOrder();
	 document.add(new Paragraph("Destinataire :   "+ o.getIdOrder()));
	 SimpleDateFormat formater = null;
	 formater = new SimpleDateFormat("dd-MM-yy");
	
	 

	 
	 Font mainFont = FontFactory.getFont("Cooper Black",35, BaseColor.BLACK);
	 Paragraph para=new Paragraph("Bill N° "+o.getIdOrder(),mainFont);
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
	   
	    PdfPCell quantiteval = new PdfPCell(new Paragraph(String.valueOf(o.getProductNumberOrder()) , tableHeader));
 	    quantiteval.setBorderColor(BaseColor.BLACK);
 	    quantiteval.setPaddingLeft(10);
 	    quantiteval.setHorizontalAlignment(Element.ALIGN_CENTER);
 	    quantiteval.setVerticalAlignment(Element.ALIGN_CENTER);
 	    quantiteval.setBackgroundColor(BaseColor.WHITE);
 	    quantiteval.setExtraParagraphSpace(5f);
 	    table.addCell(quantiteval);
 	    
 	    
 	    PdfPCell produiteval = new PdfPCell(new Paragraph(String.valueOf(o.getStateOrder() ), tableHeader));
 	    produiteval.setBorderColor(BaseColor.BLACK);
 	    produiteval.setPaddingLeft(10);
 	    produiteval.setHorizontalAlignment(Element.ALIGN_CENTER);
 	    produiteval.setVerticalAlignment(Element.ALIGN_CENTER);
 	    produiteval.setBackgroundColor(BaseColor.WHITE);
 	    produiteval.setExtraParagraphSpace(5f);
 	    table.addCell(produiteval);
 	    
 	    
 	    PdfPCell prixval = new PdfPCell(new Paragraph(String.valueOf(o.getAmountOrder() ), tableHeader));
 	    prixval.setBorderColor(BaseColor.BLACK);
 	    prixval.setPaddingLeft(10);
 	    prixval.setHorizontalAlignment(Element.ALIGN_CENTER);
 	    prixval.setVerticalAlignment(Element.ALIGN_CENTER);
 	    prixval.setBackgroundColor(BaseColor.WHITE);
 	    prixval.setExtraParagraphSpace(5f);
 	    table.addCell(prixval);
 	    
 	    PdfPCell Totaleval = new PdfPCell(new Paragraph(String.valueOf(o.getPaymentType()), tableHeader));
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
	


