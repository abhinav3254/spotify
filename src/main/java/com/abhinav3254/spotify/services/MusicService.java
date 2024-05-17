package com.abhinav3254.spotify.services;


import com.abhinav3254.spotify.dto.MusicDTO;
import com.abhinav3254.spotify.model.Music;
import com.abhinav3254.spotify.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.abhinav3254.spotify.model.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Service
public class MusicService {

    @Autowired
    private MusicRepository musicRepository;

    public Music addMusic(MusicDTO musicDTO) {
        Music music = new Music();
        music.setName(musicDTO.getName());
        try {
            music.setMusicFile(musicDTO.getMusic().getBytes());
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

        return musicRepository.save(music);

    }

    public ResponseEntity<?> getMusicById(Long id) {
        Music music = musicRepository.getMusicById(id);
        if (music == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        ByteArrayResource resource = new ByteArrayResource(music.getMusicFile());
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + music.getName() + "\"")
                .contentLength(music.getMusicFile().length)
                .body(resource);
    }

}
