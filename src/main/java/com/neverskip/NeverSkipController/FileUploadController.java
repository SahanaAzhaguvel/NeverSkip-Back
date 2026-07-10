package com.neverskip.NeverSkipController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.neverskip.NeverSkipCSV.CSVService;

@RestController
@RequestMapping("/upload")
public class FileUploadController {
    @Autowired
	private CSVService csvService;
    
    @PostMapping("/csv")
    public String uploadCSV(@RequestParam("file") MultipartFile file) {
    	csvService.saveCSV(file);
    	
    	return "CSV Uploaded Successfully!";
    }
}
