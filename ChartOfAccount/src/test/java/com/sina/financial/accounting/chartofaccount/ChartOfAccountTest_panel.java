package com.sina.financial.accounting.chartofaccount;

import com.sina.financial.accounting.chartofaccount.api.ChartOfAccountController;
import com.sina.financial.accounting.chartofaccount.api.dto.ChartOfAccountDTO;
import com.sina.financial.accounting.chartofaccount.domain.ChartOfAccount;
import com.sina.financial.accounting.config.TestConfig;
import com.sina.financial.accounting.enumeration.GeneralLedgerClassification;
import com.sina.financial.accounting.tokenhelper.TokenHelper;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = TestConfig.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ChartOfAccountTest_panel {

    private static final String LOCAL_HOST_URI = "http://localhost:";
    @LocalServerPort
    private int portNumber;
    @Autowired
    private ChartOfAccountController chartOfAccountController;

    @Autowired
    private TestRestTemplate rest;

    private String token;
    @BeforeAll
    public void getBackOfficeUserToken() {
        token = TokenHelper.getTokenForBackOfficeClerkUser(rest);
    }

    @Test
    public void testCreateChartOfAccount() {

        ChartOfAccountDTO dto = ChartOfAccountDTO.builder()
                .parentId("0")
                .generalLedgerCode("1000")
                .name("Cash")
                .shortName("cash")
                .active("true")
                .classification(GeneralLedgerClassification.ASSET.toString())
                .description("cash")
                .build();
        String url = LOCAL_HOST_URI + portNumber + "/api/v1/chart-of-account/panel/create-action";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "bearer " + token);

        HttpEntity<ChartOfAccountDTO> request = new HttpEntity<>(dto, headers);
        ResponseEntity<String> response = rest.postForEntity(url, request, String.class);
        Assertions.assertTrue(response.getBody().equals("ok"));
    }
}
