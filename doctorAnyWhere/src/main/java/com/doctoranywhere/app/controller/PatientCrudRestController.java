package com.doctoranywhere.app.controller;

import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doctoranywhere.app.bean.Message;
import com.doctoranywhere.app.bean.PatientDetailWrapper;
import com.doctoranywhere.app.model.PatientDetailModel;
import com.doctoranywhere.app.service.IPatientDetailService;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;


@CrossOrigin
@RestController
public class PatientCrudRestController {
	
	
	
	
	
	 @Autowired
	    private IPatientDetailService patientDetailService;
	
	 
	 
	 
	
	 
	 
	 
	@RequestMapping("/patient/api/v1/{pageNo}/{pageSize}")
	public PatientDetailWrapper getAllPateintDetails(HttpServletRequest request,HttpServletResponse response,
			@RequestHeader( required = true) String idToken,
			@PathVariable int pageNo, 
            @PathVariable int pageSize) throws InterruptedException, ExecutionException
	{
		String isDeleted=request.getParameter("deleted");
		
		System.out.println(idToken);
		
		PatientDetailWrapper patientDetail=new PatientDetailWrapper();
		try {

			
			/*
			 * FirebaseToken decodedToken =
			 * FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get();
			 * System.out.println("decodedToken:"+decodedToken);
			 */
			 
		}
		catch(Exception e) {
			e.printStackTrace();
			response.setStatus(401);
			patientDetail.setMessage("Authorization failled");
			return patientDetail;
		}
		 
		
		
		
     if("Y".equalsIgnoreCase(isDeleted)) {
    	 patientDetail= patientDetailService.getAllActivePateintDetails(pageNo, pageSize,isDeleted);
		}
     else {
    	 patientDetail= patientDetailService.findPaginated(pageNo, pageSize);
     }
		
	 System.out.println(patientDetail);
	 return patientDetail;
	}
	
	

	
	@RequestMapping( method=RequestMethod.POST, value="/patient/api/v1")
	public Message addPateintDetail(@RequestBody PatientDetailModel patientDetailModel,
			HttpServletResponse response,
			@RequestHeader( required = true) String idToken)
	{
		
		Message message=new Message();
		message.setMessage("Patient added succussfully");
		try {

			
			  FirebaseToken decodedToken =
			  FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get();
			  System.out.println("decodedToken:"+decodedToken);
			 
		}
		catch(Exception e) {
			e.printStackTrace();
			
			message.setMessage("Authorization failled");
			message.setStatusCode(401);
			response.setStatus(401);
			return message;
		}
		patientDetailService.addUpdate(patientDetailModel);
		
		return message;
	}
	
	
	@RequestMapping( method=RequestMethod.PUT, value="/patient/api/v1")
	public Message updatePatientDetail(@RequestBody PatientDetailModel patientDetailModel,
			HttpServletResponse response,
			@RequestHeader( required = true) String idToken)
	{
		
		Message message=new Message();
		message.setMessage("Patient updated succussfully");
		try {

			
			  FirebaseToken decodedToken =
			  FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get();
			  System.out.println("decodedToken:"+decodedToken);
			 
		}
		catch(Exception e) {
			e.printStackTrace();
			
			message.setMessage("Authorization failled");
			message.setStatusCode(401);
			response.setStatus(401);
			return message;
		}
		
     patientDetailService.addUpdate(patientDetailModel);
		
		return message;
	}
	 
	@RequestMapping(value = "/patient/api/v1/{id}", method = RequestMethod.DELETE)
	public Message deletePatientDetail(@PathVariable("id") String id,
			HttpServletResponse response,
			@RequestHeader( required = true) String idToken) {
		Message message=new Message();
		message.setMessage("Patient deleted succussfully");
		try {

			
			  FirebaseToken decodedToken =
			  FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get();
			  System.out.println("decodedToken:"+decodedToken);
			 
		}
		catch(Exception e) {
			e.printStackTrace();
			
			message.setMessage("Authorization failled");
			message.setStatusCode(401);
			response.setStatus(401);
			return message;
		}

		Long userId = Long.parseLong(id);
		 patientDetailService.deleteById(userId);
		 return message;
	}


}
