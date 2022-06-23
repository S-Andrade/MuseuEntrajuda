package com.entrajuda.museu.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.multipart.MultipartFile;


import org.springframework.http.MediaType;


import java.io.IOException;
import java.util.Optional;


@RestController
@RequestMapping(path="/image")
public class ImageController {

    @Autowired
    ImageRepository imageRepository;

    
    @PostMapping("/upload")
    public @ResponseBody String uplaodImage(@RequestParam("image") MultipartFile file) throws IOException {

        Image new_image = new Image(file.getOriginalFilename(), file.getContentType(), ImageUtility.compressImage(file.getBytes()));
        imageRepository.save(new_image);
        
                return "Saved";
    }
    
    @GetMapping(path = {"/{image_id}"})
    public ResponseEntity<byte[]> getImage(@PathVariable("image_id") Integer image_id) throws IOException {

        final Optional<Image> dbImage = imageRepository.findById(image_id);

        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(dbImage.get().getType()))
                .body(ImageUtility.decompressImage(dbImage.get().getImage()));
    }
}
