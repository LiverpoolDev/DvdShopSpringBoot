package com.sterlit.dvd.controller;


import com.sterlit.dvd.entity.Staff;
import com.sterlit.dvd.repo.StaffRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("/staff")
@RestController
public class StaffController {

    private StaffRepository staffRepository;

    @GetMapping("/get/{id}")
    public Staff findById(@PathVariable Long id) {
        return staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Персонал с указаным ID %d не найден", id)));
    }

}
