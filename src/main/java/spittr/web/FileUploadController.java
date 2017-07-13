package spittr.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.io.File;
import java.io.IOException;

import javax.servlet.FilterRegistration;
import javax.servlet.http.Part;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/")
public class FileUploadController {
	static{
		System.out.println("FileUploadController");
	}
	
	@RequestMapping(method = GET)
	public String showRegistrationForm() {
		return "registerForm";
	}

	@RequestMapping(method = POST)
	public String processRegistration(@RequestPart("profilePicture") Part profilePicture, String firstName)
			throws IllegalStateException, IOException {
		System.out.println("profilePicture.getName(): "+profilePicture.getName());
		System.out.println("profilePicture.getSize(): "+profilePicture.getSize());
		System.out.println("profilePicture.getContentType(): "+profilePicture.getContentType());
		for(String headerName:profilePicture.getHeaderNames()){
			System.out.println("header "+headerName+": "+profilePicture.getHeader(headerName));
		}
		profilePicture.write("D:/d/data/temp/profile_picture/" + "part_picture.jpg");
		return "successfully_uploaded_check_terminal";
	}

}
