package com.numetry.www.service;

import java.time.LocalTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;import org.springframework.util.MultiValueMap;

import com.numetry.www.Repository.CustumerRepository;
import com.numetry.www.Repository.VerificationRepository;
import com.numetry.www.dto.VerificationDTO;
import com.numetry.www.entity.SmsDetails;
import com.numetry.www.entity.Verification;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.vonage.client.VonageClient;
import com.vonage.client.sms.MessageStatus;
import com.vonage.client.sms.SmsSubmissionResponse;
import com.vonage.client.sms.SmsSubmissionResponseMessage;
import com.vonage.client.sms.messages.TextMessage;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;


@Component
public class SmsService {

	    
	   

	    public void receive(MultiValueMap<String, String> smscallback) {
	    }
	    
	    @Autowired
	    CustumerRepository custumerRepository;
	    
	    @Autowired
	    VerificationRepository verificationRepository;
	    
	    @Autowired
	    ModelMapper modelMapper;
	    
	    @Value("${spring.mail.username}") 
		   private String sender;
		   
		@Autowired JavaMailSender javaMailSender;
			
		   	SimpleMailMessage smm= new SimpleMailMessage();
			
	    public String generateOtp()
	    {
	    	
		 // Generate a random number between 0.0 and 1.0
	        double randomDouble = Math.random();
	        
	        // Multiply the random number by 1,000,000 and cast to an integer
	        int randomInt = (int)(randomDouble * 1000000);
	        
	        // Convert the integer to a string
	        String otp = String.format("%06d", randomInt);
	     
	        // Print the OTP
	        System.out.println("Generated OTP: " + otp);
	        return otp;
	        
	    }
	    // Email Verification using SMTP
		public String sendEmailOtp(String Email) throws MessagingException 
		{
		     
	    String otp=generateOtp();
            
	        // Create a MimeMessage
	        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

	        // Build the email content using HTML
	        StringBuilder emailContent = new StringBuilder();
	        emailContent
	        			.append("<p>Dear User,</p>")
	                    .append("<p>Thank you for registering with Travel Bliss.</p>")
	                    .append("<p>Your One-Time Passwor for email verification is:</p>")
	                    .append("<h3>OTP: ").append(otp).append("</h3>")
	                    .append("<p>This otp will valid upto 5 minutes only</p>")
	                    .append("<p>Please enter this OTP to verify your email address.</p>")
	                    .append("<p>If you did not request this, please ignore this email.</p>")
	                    .append("<p>Best Regards,<br>Travel Bliss Team</p>");
	                    

	        // Set email details
	        helper.setText(emailContent.toString(), true); // true indicates HTML
	        helper.setFrom(sender);
	        helper.setTo(Email);
	        helper.setSubject("Email Verification for Travel Bliss");
	        
	        VerificationDTO verificationDto = new VerificationDTO();
	        
	        Verification exisitingEmail= verificationRepository.findByEmailId(Email);
	        if(exisitingEmail!=null)
	        {
	        	exisitingEmail.setEmailOtp(otp);
	        	exisitingEmail.setEmailOtpCreatedTime(LocalTime.now().plusMinutes(5));
//	            Verification verification = modelMapper.map(verificationDto, Verification.class);
		        verificationRepository.save(exisitingEmail);
	        }
	        else if(exisitingEmail==null)
	        {
	        	verificationDto.setEmailId(Email);
		        verificationDto.setEmailOtp(otp);
		        verificationDto.setEmailOtpCreatedTime(LocalTime.now().plusMinutes(5));
		        Verification verification = modelMapper.map(verificationDto, Verification.class);
		        verificationRepository.save(verification);
	        }
	        
	        	
	        
	        
	   

	        // Send the email
	        javaMailSender.send(mimeMessage);
	        
			
			
			
			return "Mail sent Succesfully";
		}
		
		public ResponseEntity<String> verifyEmailOtp(String emailOtp)
		{
			Verification expriredData=verificationRepository.findByEmailOtpCreatedTimeBefore(LocalTime.now());
			if(expriredData!=null)
			{
				verificationRepository.delete(expriredData);	
			}
			
			if(verificationRepository.findByEmailOtp(emailOtp)!=null)
			{
				return ResponseEntity.ok().body("Otp verified Succesfully");
			}
			else
			{
				return ResponseEntity.badRequest().body("Invalid Otp");
			}	
		}
		
	
	    private final VonageClient vonageClient;

	   
	    public SmsService(@Value("${vonage.api.key}") String apiKey,
	                      @Value("${vonage.api.secret}") String apiSecret) {
	        this.vonageClient = VonageClient.builder()
	                .apiKey(apiKey)
	                .apiSecret(apiSecret)
	                .build();
	    }

		public void sendSms(String to) {
			
			String otp=generateOtp();
			String from="Sushmidhar";
			String text="Thank you for registering with Travel Bliss, One-Time-Password: "+otp+". Otp will valid upto 5 minutes Only. ";
			
			 TextMessage message = new TextMessage(from, "91"+to, text);

			 VerificationDTO verificationDto = new VerificationDTO();
		        
		        Verification exisitingMobile= verificationRepository.findByMobileNumber(to);
		        if(exisitingMobile!=null)
		        {
		        	exisitingMobile.setMobileOtp(otp);
		        	exisitingMobile.setMobileOtpCreatedTime(LocalTime.now().plusMinutes(5));
//		            Verification verification = modelMapper.map(verificationDto, Verification.class);
			        verificationRepository.save(exisitingMobile);
		        }
		        else if(exisitingMobile==null)
		        {
		        	verificationDto.setMobileNumber(to);
			        verificationDto.setMobileOtp(otp);
			        verificationDto.setMobileOtpCreatedTime(LocalTime.now().plusMinutes(5));
			        Verification verification = modelMapper.map(verificationDto, Verification.class);
			        verificationRepository.save(verification);
		        }
		        
		        	
			 
		        SmsSubmissionResponse response = vonageClient.getSmsClient().submitMessage(message);

		        for (SmsSubmissionResponseMessage responseMessage : response.getMessages()) {
		            if (responseMessage.getStatus() == MessageStatus.OK) {
		                System.out.println("Message sent successfully.");
		            } else {
		                System.out.println("Message failed with error: " + responseMessage.getErrorText());
		            }
		        }
			
		}
		
		
		public ResponseEntity<String> verifyMobileOtp(String mobileOtp)
		{
			Verification expriredData=verificationRepository.findByMobileOtpCreatedTimeBefore(LocalTime.now());
			if(expriredData!=null)
			{
				verificationRepository.delete(expriredData);	
			}
			
			if(verificationRepository.findByMobileOtp(mobileOtp)!=null)
			{
				return ResponseEntity.ok().body("Otp verified Succesfully");
			}
			else
			{
				return ResponseEntity.badRequest().body("Invalid Otp");
			}	
		}
	
}



