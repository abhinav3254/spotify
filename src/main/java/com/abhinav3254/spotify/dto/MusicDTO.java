package com.abhinav3254.spotify.dto;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MusicDTO {
    private String name;
    private MultipartFile music;
}
