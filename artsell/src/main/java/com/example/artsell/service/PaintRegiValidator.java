package com.example.artsell.service;

import java.util.Date;

import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.example.artsell.domain.Account;
import com.example.artsell.domain.ItemForm;

public class PaintRegiValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Account.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {
		ItemForm model = (ItemForm) obj;
		
		MultipartFile file = model.getPicturefile();
//		String file = model.getPicture();//연제 테스트
		
		if(file.isEmpty()){
            errors.rejectValue("picturefile", "upload.file.required");
        }
		
		Date deadline =  model.getDeadline();
		if(deadline == null) {
			errors.rejectValue("deadline", "NotBlank");
		}
//		if (file == null) {
//			errors.rejectValue("picture", "upload.file.required");
//		}
	
//	    for (CommonsMultipartFile multipartFile: commonsMultipartFiles) {
//	        if (multipartFile.getSize() == 0) {
//	            errors.rejectValue("files", "myapplication.missing.file");
//	        }
//	    }
	}

}
