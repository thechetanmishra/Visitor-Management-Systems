package com.example.vms.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.vms.entity.VendorDetails;
import com.example.vms.service.VisitorService;

@RestController
public interface VisitorManagementController {
	@Autowired
	public VisitorService visitorService = null;
	
	static final Logger logger = LoggerFactory.getLogger(VisitorManagementController.class);

	Map<Integer, VendorDetails> empData = new HashMap<Integer, VendorDetails>();
	
//	@GetMapping("/students/{studentId}/courses")
//	public List<Course> retrieveCoursesForStudent(@PathVariable String studentId) {
//		return studentService.retrieveCourses(studentId);
//	}
	
	@RequestMapping(value = "/visitor/create", method = RequestMethod.POST)
	public @ResponseBody
	static VendorDetails createVendor(@RequestBody VendorDetails vendor) {
		logger.info("Start createVisitors.");
		visitorService.createVendor();
//		emp.setCreatedDate(new Date());
//		empData.put(emp.getId(), emp);
		return null;
	}
}
