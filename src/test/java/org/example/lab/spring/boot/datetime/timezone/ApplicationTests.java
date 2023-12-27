package org.example.lab.spring.boot.datetime.timezone;

import org.assertj.core.api.Assertions;
import org.example.lab.spring.boot.datetime.timezone.controller.response.DtResponse;
import org.example.lab.spring.boot.datetime.timezone.service.DtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private DtService dtService;

    @Test
    void contextLoads() {
        Assertions.assertThatNoException().isThrownBy(() -> {
            Long id = dtService.create();
            DtResponse response = dtService.findById(id);
            Assertions.assertThat(response)
                    .isNotNull()
                    .extracting("id").isEqualTo(id);
        });
    }
}
