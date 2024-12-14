package ru.netology.diplom_cloud_storage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "Files")
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @JsonProperty("filename")
    @Column(nullable = false)
    private String filename;

    @JsonProperty("size")
    private Long size;

    @JsonIgnore
    @Column(nullable = false)
    private String filepath;

    @JsonIgnore
    @OneToOne
    private UserEntity userEntity;
}
