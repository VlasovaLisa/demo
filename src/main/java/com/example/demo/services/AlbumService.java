package com.example.demo.services;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.example.demo.models.*;
import com.example.demo.repositories.AlbumRepository;

@Service
@AllArgsConstructor
public class AlbumService {
    private final AlbumRepository albumRepository;

    @Transactional(readOnly = true)
    public List<Album> getAllAlbums() {
        return albumRepository.findAll(Sort.by("title"));
    }

    @Transactional(readOnly = true)
    public Optional<Album> getAlbumById(Long id) {
        return albumRepository.findById(id);
    }

    @Transactional
    public void addAlbum(Album album) {
        albumRepository.save(album);
    }

    @Transactional
    public void addNewAlbum(String title, LocalDate releaseDate, Artist artist, Group group) {
        Album album = new Album();
        album.setTitle(title);
        album.setReleaseDate(releaseDate);
        album.setArtist(artist);
        album.setGroup(group);
        albumRepository.save(album);
    }

    @Transactional
    public void updateAlbum(Long id, Album albumDetails) {
        Album album = albumRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid album Id: " + id));
        album.setTitle(albumDetails.getTitle());
        album.setReleaseDate(albumDetails.getReleaseDate());
        album.setArtist(albumDetails.getArtist());
        album.setGroup(albumDetails.getGroup());
        albumRepository.save(album);
    }

    @Transactional
    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }
}
