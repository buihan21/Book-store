package com.baitaplon.bookstore.service.impl;

import com.baitaplon.bookstore.service.IStorageService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class StorageService implements IStorageService {
    @Override
    public ByteArrayResource readContentFile(String photo) {
        if (!photo.equals("") || photo != null) {
            try{
                Path fileName = Paths.get("upload/bookImage", photo);
                byte[] buffer = Files.readAllBytes(fileName);
                ByteArrayResource byteArrayResource = new ByteArrayResource(buffer);
                return byteArrayResource;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
