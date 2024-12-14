package ru.netology.diplom_cloud_storage.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.diplom_cloud_storage.entity.FileEntity;
import ru.netology.diplom_cloud_storage.service.FileService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/list")
public class ListController {

    private final FileService fileService;

    @GetMapping
    List<FileEntity> getList(@RequestParam int limit) {
        return fileService.getList(limit);
    }
}
