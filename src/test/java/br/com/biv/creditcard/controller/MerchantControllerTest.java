package br.com.biv.creditcard.controller;

import br.com.biv.creditcard.controller.mapper.merchant.MerchanToMerchanResourceMapper;
import br.com.biv.creditcard.domain.model.Merchant;
import br.com.biv.creditcard.domain.service.MerchantService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MerchantController.class)
class MerchantControllerTest {

    @MockBean
    MerchantService merchantService;
    @MockBean
    MerchanToMerchanResourceMapper merchanToMerchanResourceMapper;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @Test
    void shouldCreateMockMvc() {
        assertNotNull(mockMvc);
    }

    @Test
    public void shouldReturnSuccess_WhenGetMerchantById() throws Exception {

        final Merchant merchant = Merchant
                .builder()
                .merchantId(10L)
                .name("UBER")
                .state("SP")
                .country("BR")
                .build();

        when(merchantService.findById(merchant.getMerchantId())).thenReturn(Optional.of(merchant));

        this.mockMvc
                .perform(get("/merchants/{merchantId}", 10))
                .andExpect(status().isOk());

        verify(merchanToMerchanResourceMapper, atLeastOnce()).convertToMerchantResponse(any());
        assertEquals("UBER", merchant.getName());
    }
}