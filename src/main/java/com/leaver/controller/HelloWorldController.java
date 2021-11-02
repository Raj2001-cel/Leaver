package com.leaver.controller;

import com.leaver.dao.ImageRepository;
import com.leaver.model.ImageModel;
import com.leaver.model.Leaf;
import com.leaver.model.Report;
import com.leaver.service.LeafService;
import com.leaver.service.ReportService;
import org.deeplearning4j.nn.modelimport.keras.exceptions.InvalidKerasConfigurationException;
import org.deeplearning4j.nn.modelimport.keras.exceptions.UnsupportedKerasConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.leaver.util.ImageProcessing.compressBytes;

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
	public ResponseEntity<Leaf> postImage(@RequestParam("imageFile") MultipartFile file,@PathVariable("reportId") Long reportId) throws IOException, UnsupportedKerasConfigurationException, InvalidKerasConfigurationException {
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
	public Report saveReport(@RequestBody Report report){

		return reportService.save(report);
	}

	@GetMapping(name = "/report")
	public List<Report> getAllReport(){
		return reportService.getAllReports();
	}



	public boolean predict(ImageModel imageModel) throws IOException, UnsupportedKerasConfigurationException, InvalidKerasConfigurationException {
		//load the model
//		String simpleMlp = new ClassPathResource("saved_model.pb").getFile().getPath();
//		MultiLayerNetwork model = KerasModelImport.importKerasSequentialModelAndWeights(simpleMlp);
////		MultiLayerNetwork model = ModelSerializer.restoreMultiLayerNetwork("C:/Users/Raj/Downloads/LoginUsingJWT-main/LoginUsingJWT-main/models/1");
//		InputStream is = new ByteArrayInputStream(imageModel.getPicByte());
//		BufferedImage bi = ImageIO.read(is);
//		ImageLoader loader = new ImageLoader(224, 224, 3);
//		INDArray input = loader.asMatrix(is);
//		// prediction from the model
//		System.out.println("MODEL PREDICTION IS -----> "+model.predict(input));
//		// load the model
//
//
//		//return in boolean
//		String charset = "UTF-8";
//		String requestURL = "http://127.0.0.1:5001/predict";
//
//		MultipartUtility multipart = new MultipartUtility(requestURL, charset);
//		multipart.addFormField("param_name_1", "param_value");
//		multipart.addFormField("param_name_2", "param_value");
//		multipart.addFormField("param_name_3", "param_value");
//		multipart.addFilePart("file_param_1", new File(file_path));
//		String response = multipart.finish(); // response from server.
		return true;
	}









}