package com.doctoranywhere.app.service;

import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class AppFirebaseInitialize {
	
	@PostConstruct
	public void initialize() {
		try {
			System.out.println("**************AppFirebaseInitialize**************");
		
			Resource resource = new ClassPathResource("classpath:docsapp-2e324-firebase-adminsdk-fhjlu-71d773688f.json");
		InputStream serviceAccount =resource.getInputStream();
				  //new FileInputStream("docsapp-2e324-firebase-adminsdk-fhjlu-71d773688f.json");

				FirebaseOptions options = new FirebaseOptions.Builder()
				  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
				  .setDatabaseUrl("https://docsapp-2e324.firebaseio.com")
				  .build();

				FirebaseApp.initializeApp(options);
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
