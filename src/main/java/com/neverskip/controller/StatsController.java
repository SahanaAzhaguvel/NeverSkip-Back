package com.neverskip.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neverskip.repository.StudentRepository;

@RestController
@RequestMapping("/stats")

public class StatsController {
	
	@Autowired
    private StudentRepository repository;

    @GetMapping("")
    public Map<String, Object> getStats() {

        Map<String, Object> stats = new HashMap<>();

        long totalStudents = repository.count();
        Double avgScore = repository.findAverageScore();
        int totalClasses = repository.findDistinctClassNames().size();

        stats.put("totalStudents", totalStudents);
        stats.put("avgScore", avgScore != null ? Math.round(avgScore) : 0);
        stats.put("totalClasses", totalClasses);

        return stats;
    }
}

