package by.pochepko.controller;

import by.pochepko.dto.ChocolateDto;
import by.pochepko.service.ChocolateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ChocolateRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ChocolateService chocolateService;

    @Test
    void getChocolatesShouldReturnString() throws Exception {

        //given
        List<ChocolateDto> chocolates = new ArrayList<>();
        ChocolateDto chocolate = new ChocolateDto();
        chocolate.setName("Twinx");
        chocolate.setPrice(50);
        chocolates.add(chocolate);
        when(chocolateService.getChocolateLst()).thenReturn(chocolates);
        //when //then
        mockMvc.perform(get("/chocolates")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"name\":\"Twinx\",\"price\":50}")));

    }

}