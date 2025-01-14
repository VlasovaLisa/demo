package com.example.demo.controllers;

import com.example.demo.models.Artist;
import com.example.demo.services.ArtistService;
import com.example.demo.services.GroupService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/artists")
@AllArgsConstructor
public class ArtistController {
    private final ArtistService artistService;
    private final GroupService groupService;

    @GetMapping
    public String getAllArtists(Model model) {
        List<Artist> artists = artistService.getAllArtists();
        model.addAttribute("artists", artists);
        return "artists";
    }

    @GetMapping("/new")
    public String createArtistForm(Model model) {
        model.addAttribute("artist", new Artist());
        model.addAttribute("groups", groupService.getAllGroups()); // Для выбора группы
        return "artists-new";
    }

    @PostMapping("/save")
    public String saveArtist(@ModelAttribute Artist artist) {
        artistService.addArtist(artist);
        return "redirect:/artists";
    }

    @GetMapping("/edit/{id}")
    public String editArtistForm(@PathVariable Long id, Model model) {
        Artist artist = artistService.getArtistById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid artist Id: " + id));

        // Форматирование даты
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedBirthdate = artist.getBirthdate() != null ? artist.getBirthdate().format(formatter) : null;

        model.addAttribute("artist", artist);
        model.addAttribute("formattedBirthdate", formattedBirthdate); // Передача отформатированной даты
        model.addAttribute("groups", groupService.getAllGroups()); // Для выбора новой группы
        return "artists-edit";
    }

    @PostMapping("/update/{id}")
    public String updateArtist(@PathVariable Long id, @ModelAttribute Artist artistDetails) {
        artistService.updateArtist(id, artistDetails);
        return "redirect:/artists";
    }

    @PostMapping("/delete/{id}")
    public String deleteArtist(@PathVariable Long id) {
        artistService.deleteArtist(id);
        return "redirect:/artists";
    }
}
