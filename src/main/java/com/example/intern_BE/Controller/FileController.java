package com.example.intern_BE.Controller;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class FileController {
    @Autowired
    private Cloudinary cloudinary;

    @PostMapping("/site/image/post")
    public Map upload(@RequestParam("image") MultipartFile file){
        try {
            Map map=  cloudinary.uploader().upload(file.getBytes(),Map.of());
            System.out.println(map.get("secure_url"));

            return map;
        }catch (Exception e){
            System.out.println("Unexcepted Exception");
            e.printStackTrace();
            return null;
        }

    }
}
