package com.neverskip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neverskip.model.Student;
import com.neverskip.service.StudentService;

@RestController
@CrossOrigin(origins = "*")

@RequestMapping("/school")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@PostMapping
	public Student saveStudent(@RequestBody Student student) {
		return service.saveStudent(student);
	}
	
	@GetMapping("/studentDetails")
	public List<Student> getAllStudents(){
		return service.getAllStudents();
	}
	@GetMapping("/{stdId}")
	public Student getStdById(@PathVariable("stdId") int stdId) {
	    System.out.println("Controller reached! ID = " + stdId);

		return service.getStdById(stdId);
	}
	@GetMapping("/section/{section}")
	public List<Student> getStudentBySec(@PathVariable String section){
		return service.getStudentBySec(section);
	}
	@DeleteMapping("/clear")
	public void clearAllStudent() {
		service.clearStudent();
	}
	@PutMapping("/{stdId}")
	public Student updateStudent(@PathVariable int stdId,
	                             @RequestBody Student student) {

	    return service.updateStudent(stdId, student);
	}
	@DeleteMapping("/{stdId}")
	public String deleteStudent(@PathVariable int stdId) {
		
      
	    service.deleteStudent(stdId);
	    return "Deleted Successfully";

	}
}
