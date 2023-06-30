package com.baitaplon.bookstore.controller.uploadFile;

import com.baitaplon.bookstore.service.IBookService;
import com.baitaplon.bookstore.service.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;

@RequestMapping("/api/file")
@RestController
@CrossOrigin(origins = "*")
public class UploadImage {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IStorageService storageService;

    @PostMapping("/")
    public String uploadFile(@RequestParam(name = "image") MultipartFile image) throws IOException {
        String pathString = bookService.saveImage(image);
        // chuyen thanh duong dan toi thu muc chua anh
        String urlImage = ServletUriComponentsBuilder.fromCurrentContextPath().path(pathString).toUriString();
        return pathString.substring(pathString.lastIndexOf("/") + 1);
    }

    @GetMapping("/{photo}")
    public ResponseEntity<ByteArrayResource> getImage(@PathVariable("photo") String photo) {
        ByteArrayResource byteArrayResource = storageService.readContentFile(photo);
        if (byteArrayResource == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(byteArrayResource);
    }
}
