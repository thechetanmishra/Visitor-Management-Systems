package com.example.vms.controller;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.vms.entity.VendorDetails;
import com.example.vms.model.Visitors;
import com.example.vms.respository.EmployeeRespository;
import com.example.vms.respository.VendorDetailsRespository;
import com.example.vms.utils.AsymetricKeyUtils;
import com.example.vms.utils.DigitalSignatureUtil;
import com.example.vms.utils.Mailer;

@RestController
@CrossOrigin
public class TestController {

	@Autowired
	AsymetricKeyUtils asymetricKeyUtils;

	@Autowired
	DigitalSignatureUtil DigitalSignatureUtil;

	@Autowired
	VendorDetailsRespository vendorDetailsRespository;

	@Autowired
	EmployeeRespository employeeRespository;

	@GetMapping("/test")
	public void getPath() {
		asymetricKeyUtils.getKeyValuePair();
		byte[] a = DigitalSignatureUtil.getSign("abcd2", asymetricKeyUtils.getKeyValuePair());
		String a1 = Base64.getEncoder().encodeToString(a);
		System.out.println(a1);
		try {
			System.out.print(DigitalSignatureUtil.getSignVerified("abcd", Base64.getDecoder().decode(a1),
					asymetricKeyUtils.getKeyValuePair()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@PostMapping("/visitors")
	public String createVisitor(@RequestBody Visitors vender) {
		Visitors visitor = new Visitors();
		VendorDetails vendorDetails = visitor.toVendorEntity(vender);
		
		//to-do :Unique value need to generate VIS-01
		VendorDetails savedStudent = vendorDetailsRespository.save(vendorDetails);
		return "Visitor is created ";
	}
	
	@GetMapping("/visitors/{qrCode}")
	public VendorDetails retrieveStudent(@PathVariable("qrCode") String qrCode) {
		//Optional<Visitors> student = vendorDetailsRespository.findOne(example);
		VendorDetails vendor = vendorDetailsRespository.findByQrCode(qrCode);
		System.out.println(vendor.toString());
		return vendor;
	}
	
	@GetMapping("/mail")
	public void sendEmail() {
	Mailer mail = new Mailer();
	mail.send("shahjoy831994@gmail.com", "Momai@1994", "chetanmishra05@gmail.com", "Test", "sefdsfs");
	}
	
}
