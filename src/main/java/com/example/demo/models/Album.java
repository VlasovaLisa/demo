package com.example.demo.models;

import java.time.LocalDate;
import jakarta.persistence.*;
import com.example.demo.*;

@Entity
@Table(name = "Albums")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AlbumID")
    private Long albumID;

    @Column(nullable = false)
    private String title;

    @Column(name = "ReleaseDate")
    private LocalDate releaseDate;

    @ManyToOne
    @JoinColumn(name = "ArtistID")
    private Artist artist;

    @ManyToOne
    @JoinColumn(name = "GroupID")
    private Group group;


    public Long getAlbumID() {
        return albumID;
    }

    public void setAlbumID(Long albumID) {
        this.albumID = albumID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
