package com.abhinav3254.spotify.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="music")
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Lob
    @Column(name = "music_file", columnDefinition = "LONGBLOB")
    private byte[] musicFile;

}
