package com.spring.boot.data.FileData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.boot.data.FileData.Entities.Image;
import com.spring.boot.data.FileData.Entities.Repos.ImageRepository;

@SpringBootTest
class FileDataApplicationTests {

	@Autowired
	ImageRepository imageRepo;
	
	@Test
	public void testImageSave() throws IOException {	
		Image image = new Image();
		image.setId(1L);
		image.setName("T&S Complexity");
		
		File file = new File("C:/Users/2080716/OneDrive - Cognizant/Desktop/Complexity.jpeg");
		
		byte fileContent[] = new byte[(int) file.length()];
		
		FileInputStream inputStream = new FileInputStream(file);
		
		inputStream.read(fileContent);
		
		image.setData(fileContent);
		
		imageRepo.save(image);
		inputStream.close();
	}
	
	@Test
	public void testReadImage() throws IOException {
		Image image = imageRepo.findById(1L).get();
		
		File file = new File("C:/Users/2080716/OneDrive - Cognizant/Desktop/"+image.getName());
		
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(image.getData());
		fos.close();
	}
	
}





