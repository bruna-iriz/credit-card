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
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
                .accountId(3L)
                .documentNumber("12345")
                .build();

        final Transaction transaction = Transaction
                .builder()
                .accountId(3L)
                .account(build)
                .benefitsCategories(BenefitsCategories.MEAL)
                .mcc(MCC.RESTAURANT)
                .build();
        transactionService.save(transaction);
    }

//    @Test
//    public void shouldReturnSuccess_WhenCreateTransaction() throws Exception {
//
//        final Transaction transaction = Transaction
//                .builder()
//                .accountId(Account.builder().build().getAccountId())
//                .benefitsCategories(BenefitsCategories.MEAL)
//                .mcc(MCC.RESTAURANT)
//                .totalAmount(BigDecimal.valueOf(320.00))
//                .build();
//
//        mockMvc.perform(post("/transactions")
//                .contentType(MediaType.APPLICATION_JSON)
//                .characterEncoding("UTF-8")
//                .content("{\n" +
//                        "    \"accountId\": 3,\n" +
//                        "    \"merchantId\": 2,\n" +
//                        "    \"transactionId\": 4,\n" +
//                        "    \"mcc\": \"RESTAURANT\",\n" +
//                        "    \"totalAmount\": -320.00,\n" +
//                        "    \"statusTransaction\": \"APPROVED\",\n" +
//                        "    \"eventDate\": \"2022-11-19T16:30:06.4834971\"\n" +
//                        "}"))
//                .andExpect(status().isCreated());
//    }
}

