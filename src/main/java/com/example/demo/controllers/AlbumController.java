package com.example.demo.controllers;

import com.example.demo.models.Album;
import com.example.demo.services.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/albums")
@AllArgsConstructor
public class AlbumController {
    private final AlbumService albumService;
    private final ArtistService artistService;
    private final GroupService groupService;

    @GetMapping
    public String getAllAlbums(Model model) {
        model.addAttribute("albums", albumService.getAllAlbums());
        return "albums";
    }

    @GetMapping("/new")
    public String createAlbumForm(Model model) {
        model.addAttribute("album", new Album());
        model.addAttribute("artists", artistService.getAllArtists()); // Для выбора артиста
        model.addAttribute("groups", groupService.getAllGroups());   // Для выбора группы
        return "albums-new";
    }

    @PostMapping("/save")
    public String saveAlbum(@ModelAttribute Album album) {
        albumService.addAlbum(album);
        return "redirect:/albums";
    }

//    @GetMapping("/edit/{id}")
//    public String editAlbumForm(@PathVariable Long id, Model model) {
//        Album album = albumService.getAlbumById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid album Id: " + id));
//        model.addAttribute("album", album);
//        model.addAttribute("artists", artistService.getAllArtists()); // Для выбора нового артиста
//        model.addAttribute("groups", groupService.getAllGroups());   // Для выбора новой группы
//        return "albums-edit";
//    }

    @GetMapping("/edit/{id}")
    public String editAlbumForm(@PathVariable Long id, Model model) {
        Album album = albumService.getAlbumById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid album Id: " + id));

        // Добавляем обработку null значения для даты релиза
        String formattedReleaseDate = album.getReleaseDate() != null
                ? album.getReleaseDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                : null; // Или установите строку по умолчанию, если нужно

        model.addAttribute("album", album);
        model.addAttribute("formattedReleaseDate", formattedReleaseDate);
        return "albums-edit";
    }


    @PostMapping("/update/{id}")
    public String updateAlbum(@PathVariable Long id, @ModelAttribute Album albumDetails) {
        albumService.updateAlbum(id, albumDetails);
        return "redirect:/albums";
    }

    @PostMapping("/delete/{id}")
    public String deleteAlbum(@PathVariable Long id) {
        albumService.deleteAlbum(id);
        return "redirect:/albums";
    }
}
