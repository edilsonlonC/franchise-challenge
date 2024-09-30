package com.challenge.franchise.infrastructure.api.controllers;
import com.challenge.franchise.infrastructure.api.dto.FranchiseCreateDto;
import com.challenge.franchise.infrastructure.api.dto.FranchiseResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static  org.assertj.core.api.Assertions.assertThat;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
public class FranchiseControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void franchiseRequestShouldReturnOk() {
        FranchiseCreateDto franchiseCreateDto = new FranchiseCreateDto();
        franchiseCreateDto.setName("franchise test");
        FranchiseResponseDto franchiseResponseDto = this.restTemplate
                .postForObject("http://localhost:" + port + "/franchise", franchiseCreateDto, FranchiseResponseDto.class);
        assertThat(franchiseResponseDto.getName()).isEqualTo(franchiseCreateDto.getName());
    }
}
