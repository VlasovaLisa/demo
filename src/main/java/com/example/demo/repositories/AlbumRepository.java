package com.example.demo.repositories;

import com.example.demo.models.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long>{
}
