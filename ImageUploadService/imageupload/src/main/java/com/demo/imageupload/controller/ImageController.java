package com.demo.imageupload.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.imageupload.service.ImageService;

@RestController
public class ImageController {
	@Autowired
	private ImageService imgser;
	
	@PostMapping("/upload")
	public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile file) throws IOException{
		String imgent= imgser.uploadImage(file);
		return ResponseEntity.status(HttpStatus.OK).body(imgent);
	}
	
	@GetMapping("/download/{id}")
	public ResponseEntity<?> downloadImage(@PathVariable long id){
		byte[] imgData= imgser.downloadImage(id);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png ")).body(imgData);
	}

}
