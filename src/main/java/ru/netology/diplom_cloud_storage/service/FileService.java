package ru.netology.diplom_cloud_storage.service;

import org.springframework.core.io.Resource;
import ru.netology.diplom_cloud_storage.entity.FileEntity;

import java.io.IOException;
import java.util.List;

public interface FileService {

    void postFile(String filename, byte[] fileBytes, long fileSize) throws IOException;

    void deleteFile(String filename) throws IOException;

    Resource getFile(String filename) throws IOException;

    List<FileEntity> getList(int limit);

    void renameFile(String filename, String newFileName) throws IOException;
}