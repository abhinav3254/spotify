package com.abhinav3254.spotify.controllers;


import com.abhinav3254.spotify.dto.MusicDTO;
import com.abhinav3254.spotify.model.Music;
import com.abhinav3254.spotify.services.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private MusicService musicService;

    @GetMapping("/test")
    public String testCase() {
        return "working";
    }

    @PostMapping("/add")
    public ResponseEntity<?> addMusic(@ModelAttribute MusicDTO musicDTO) {
        return ResponseEntity.ok(musicService.addMusic(musicDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMusicById(@PathVariable Long id) {
        return musicService.getMusicById(id);
    }

}
