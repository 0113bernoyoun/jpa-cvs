package com.cvs.store.staff.controller;

import com.cvs.store.staff.domain.StaffRole;
import com.cvs.store.staff.model.dto.StaffDTO;
import com.cvs.store.staff.service.StaffService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Rollback(value = false)
class StaffControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private StaffService staffService;

    @Test
    public void 직원_저장_컨트롤러_테스트() throws Exception {
        this.mockMvc.perform(
                        post("/staff/hire")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(dataToJsonString(new StaffDTO("직원1", StaffRole.NORMAL)))
                ).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void 직원_찾기_컨트롤러_테스트() throws Exception{
        //given
        staffService.saveStaff("직원1", StaffRole.NORMAL);
//        staffService.saveStaff("매니저1", StaffRole.MANAGER);

        this.mockMvc.perform(
            get("/staff/1")
        ).andDo(print())
                .andExpect(status().isOk());

    }

    private <T> String dataToJsonString(T data) throws JsonProcessingException {
        return objectMapper.writeValueAsString(data);
    }
}