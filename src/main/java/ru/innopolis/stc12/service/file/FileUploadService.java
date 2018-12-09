package ru.innopolis.stc12.service.file;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    String uploadMultipartFile(MultipartFile file);
}
