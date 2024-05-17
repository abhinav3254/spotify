package com.abhinav3254.spotify.repository;

import com.abhinav3254.spotify.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MusicRepository extends JpaRepository<Music,Long> {
    Music getMusicById(Long id);
}
