package ru.netology.diplom_cloud_storage.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.diplom_cloud_storage.entity.FileEntity;
import ru.netology.diplom_cloud_storage.entity.UserEntity;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Long> {

    List<FileEntity> findAllByUserEntity_Login(String login, Sort sort);

    List<FileEntity> findAllByUserEntity(UserEntity userEntity, Pageable pageable);

    void removeFileByFilenameAndUserEntity(String fileName, UserEntity userEntity);

    FileEntity findByFilenameAndUserEntity(String filename, UserEntity userEntity);

}