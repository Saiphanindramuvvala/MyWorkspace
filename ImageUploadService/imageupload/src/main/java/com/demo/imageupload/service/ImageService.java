package com.demo.imageupload.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.demo.imageupload.entity.ImageEntity;
import com.demo.imageupload.repository.ImageRepository;

@Service
public class ImageService {
	@Autowired
	private ImageRepository repo;
	public String uploadImage(MultipartFile file) throws IOException {
		ImageEntity imgent= repo.save(ImageEntity.builder()
				.name(file.getName())
				.type(file.getContentType())
				.imageData(file.getBytes())
				.build());
		if(imgent!= null) {
			return "image uploaded successfully: " + file.getOriginalFilename();
		}
		else
			return "image not uploaded";
	}
//	public byte[] downloadImage( String fileName) {
//		Optional<ImageEntity> imgent= repo.findByName(fileName);
//		byte[] image= imgent.get().getImageData();
//		return image;
//	}
	
	public byte[] downloadImage( long id) {
		Optional<ImageEntity> imgent= repo.findById(id);
		byte[] image= imgent.get().getImageData();
		return image;
	}

}
