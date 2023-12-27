package org.example.lab.spring.boot.datetime.timezone.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.lab.spring.boot.datetime.timezone.controller.response.DtResponse;
import org.example.lab.spring.boot.datetime.timezone.service.DtService;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Tag(name = "Datetime Controller")
@RequestMapping("dt")
@RestController
class DtController {

    private final DtService dtService;

    @PostMapping
    Long create() {
        return dtService.create();
    }

    @GetMapping(path = "{id}")
    DtResponse retrieveById(@PathVariable Long id) {
        return dtService.findById(id);
    }
}
