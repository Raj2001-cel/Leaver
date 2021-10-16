package com.javainuse.controller;

import com.javainuse.dao.ImageRepository;
import com.javainuse.model.ImageModel;
import com.javainuse.model.Leaf;
import com.javainuse.model.Report;
import com.javainuse.service.LeafService;
import com.javainuse.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.javainuse.util.ImageProcessing.compressBytes;

@RestController
public class HelloWorldController {

	@Autowired
	ImageRepository imageRepository;

	@Autowired
	LeafService leafService;

	@Autowired
	ReportService reportService;



	@GetMapping(path = {"/leaf/{reportId}"})
	public ResponseEntity<ArrayList<Leaf>> getAllLeafByReportId(@PathVariable("reportId") Long reportId){
		ArrayList<Leaf>  AllLeaves  = leafService.getAllLeafByReportId(reportId);

		return ResponseEntity.status(HttpStatus.OK).body(AllLeaves);
	}

	@PostMapping(path = {"/predict/{reportId}"})
	public ResponseEntity<Leaf> postImage(@RequestParam("imageFile") MultipartFile file,@PathVariable("reportId") Long reportId) throws IOException {
		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(),
				compressBytes(file.getBytes()));

		imageRepository.save(img);

		boolean isUnhealthy = predict(img);
		String Name = "pepper";
		byte[] image  = img.getPicByte();
		Leaf leaf = new Leaf();
		leaf.setName(Name);
		leaf.setImageBytes(image);
		leaf.setImageName();
		leaf.setUnhealthy(isUnhealthy);
		leaf.setReportId(reportId);

		leafService.saveLeaf(leaf);

		return ResponseEntity.status(HttpStatus.OK).body(leaf);
	}


	@PostMapping(name = "/report")
	public Report  saveReport(@RequestBody Report report){

		return reportService.save(report);
	}

	@GetMapping(name = "/report")
	public List<Report> getAllReport(){
		return reportService.getAllReports();
	}

	public boolean predict(ImageModel imageModel){
		//load the model

		// prediction from the model

		//return in boolean

		return true;
	}







}