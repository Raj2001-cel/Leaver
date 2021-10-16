package com.javainuse.controller;

import com.javainuse.dao.ImageRepository;
import com.javainuse.dao.LeafRepository;
import com.javainuse.model.ImageModel;
import com.javainuse.model.Leaf;
import com.javainuse.service.LeafService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import static com.javainuse.util.ImageProcessing.compressBytes;
import static com.javainuse.util.ImageProcessing.decompressBytes;

@RestController
public class HelloWorldController {

	private final String UPLOAD_DIR = "C:/Users/Raj/Downloads/LoginUsingJWT-main/LoginUsingJWT-main/uploads/";
	@Autowired
	ImageRepository imageRepository;


	@Autowired
	LeafService leafService;
//	@PostMapping("/upload")
//	public ResponseEntity<ImageModel> uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
//		System.out.println("Original Image Byte Size - " + file.getBytes().length);
//		ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(),
//				compressBytes(file.getBytes()));
//		imageRepository.save(img);
//		return ResponseEntity.status(HttpStatus.OK).body(img);
//	}
//
//
//
//	@GetMapping(path = { "/upload/{imageName}" })
//	public ImageModel getImage(@PathVariable("imageName") String imageName) throws IOException {
//		final Optional<ImageModel> retrievedImage = imageRepository.findByName(imageName);
//		ImageModel img = new ImageModel(retrievedImage.get().getName(), retrievedImage.get().getType(),
//				decompressBytes(retrievedImage.get().getPicByte()));
//		return img;
//	}


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


	public boolean predict(ImageModel imageModel){
		//load the model

		// prediction from the model

		//return in boolean

		return true;
	}




}