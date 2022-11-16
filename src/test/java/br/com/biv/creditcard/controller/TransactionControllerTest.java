package br.com.biv.creditcard.controller;

import br.com.biv.creditcard.controller.mapper.transaction.TransactionToTransactionResourceMapper;
import br.com.biv.creditcard.domain.enums.BenefitsCategories;
import br.com.biv.creditcard.domain.enums.MCC;
import br.com.biv.creditcard.domain.model.Account;
import br.com.biv.creditcard.domain.model.Transaction;
import br.com.biv.creditcard.domain.service.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TransactionController.class)
class TransactionControllerTest {


    @MockBean
    TransactionService transactionService;
    @MockBean
    TransactionToTransactionResourceMapper transactionMapper;
    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldCreateMockMvc() {
        assertNotNull(mockMvc);
    }


    @BeforeEach
    void build() {
        final Account build = Account
                .builder()
                .accountId(1L)
                .documentNumber("12345678")
                .build();

        final Transaction transaction = Transaction
                .builder()
                .accountId(1L)
                .account(build)
                .build();
        transactionService.save(transaction);
    }

//    @Test
//    public void shouldReturnSuccess_WhenCreateTransaction() throws Exception {
//
//        final Transaction transaction = Transaction
//                .builder()
//                .accountId(Account.builder().build().getAccountId())
//                .benefitsCategories(BenefitsCategories.FOOD)
//                .mcc(MCC.AUDIOVISUAL_MEDIA)
//                .totalAmount(BigDecimal.valueOf(600.00))
//                .build();
//
//        mockMvc.perform(post("/transactions")
//                .contentType(MediaType.APPLICATION_JSON)
//                .characterEncoding("UTF-8")
//                .content("{\n" +
//                        "    \"transactionId\": 4,\n" +
//                        "    \"mcc\": \"AUDIOVISUAL_MEDIA\",\n" +
//                        "    \"amount\": 600.00,\n" +
//                        "    \"eventDate\": \"2022-11-15T23:49:38.4747034\"\n" +
//                        "}"))
//                .andExpect(status().isCreated());
//    }
}

