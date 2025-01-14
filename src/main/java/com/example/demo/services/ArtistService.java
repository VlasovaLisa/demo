package com.example.demo.services;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.example.demo.models.*;
import com.example.demo.repositories.ArtistRepository;

@Service
@AllArgsConstructor
public class ArtistService {
    private final ArtistRepository artistRepository;

    @Transactional(readOnly = true)
    public List<Artist> getAllArtists() {
        return artistRepository.findAll(Sort.by("name"));
    }

    @Transactional(readOnly = true)
    public Optional<Artist> getArtistById(Long id) {
        return artistRepository.findById(id);
    }

    @Transactional
    public void addArtist(Artist artist) {
        artistRepository.save(artist);
    }

    @Transactional
    public void addNewArtist(String name, String gender, LocalDate birthdate, Group group) {
        Artist artist = new Artist();
        artist.setName(name);
        artist.setGender(gender);
        artist.setBirthdate(birthdate);
        artist.setGroup(group);
        artistRepository.save(artist);
    }

    @Transactional
    public void updateArtist(Long id, Artist artistDetails) {
        Artist artist = artistRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid artist Id: " + id));
        artist.setName(artistDetails.getName());
        artist.setGender(artistDetails.getGender());
        artist.setBirthdate(artistDetails.getBirthdate());
        artist.setGroup(artistDetails.getGroup());
        artistRepository.save(artist);
    }

    @Transactional
    public void deleteArtist(Long id) {
        artistRepository.deleteById(id);
    }
}
