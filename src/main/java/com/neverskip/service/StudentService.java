package com.neverskip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neverskip.model.Student;
import com.neverskip.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;
	
	public Student saveStudent(Student student) {
		return repository.save(student);
	}
	
	public List<Student> getAllStudents(){
		return repository.findAll();
	}
	public Student getStdById(int stdId){
		return repository.findById(stdId).orElse(new Student());
	}
	public List<Student> getStudentBySec(String section){
		return repository.findBySection(section);
	}
	public void clearStudent() {
		repository.deleteAll();
	}
	// Update Student
	public Student updateStudent(int stdId, Student updatedStudent) {

	    Student student = repository.findById(stdId).orElse(null);

	    if(student != null) {

	        student.setStdName(updatedStudent.getStdName());
	        student.setClassName(updatedStudent.getClassName());
	        student.setSection(updatedStudent.getSection());
	        student.setScore(updatedStudent.getScore());

	        return repository.save(student);
	    }

	    return null;
	}

	// Delete Student
	public void deleteStudent(int stdId) {
	    repository.deleteById(stdId);
	}

}





