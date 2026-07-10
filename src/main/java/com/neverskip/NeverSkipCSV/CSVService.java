package com.neverskip.NeverSkipCSV;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.neverskip.model.Student;
import com.neverskip.repository.StudentRepository;
import com.opencsv.CSVReader;

@Service
public class CSVService {
	@Autowired
	private StudentRepository repository;
    public void saveCSV(MultipartFile file) {
    	
    	try {
    		BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
    		CSVReader csvReader = new CSVReader(reader);
    		String[] row;
    		
    		csvReader.readNext();
    		
    		while((row = csvReader.readNext()) != null) {
    			System.out.println("Reading: " + java.util.Arrays.toString(row));
    			Student student = new Student();
    			
    			student.setStdId(Integer.parseInt(row[0]));
    		    student.setStdName(row[1]);
    		    student.setClassName(row[2]);
    		    student.setSection(row[3]);
    		    student.setScore(Integer.parseInt(row[4]));


    		    repository.save(student);
    		    System.out.println("Saved: " + student.getStdName());
    		}
    	}
    	catch(Exception e) {
    		System.out.println("ERROR: " + e.getMessage());
    		e.printStackTrace();
    	}
	
}
}
