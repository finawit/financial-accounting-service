package com.sina.financial.accounting;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.time.LocalDateTime;

@EnableWebMvc
@SpringBootApplication
@Log4j2
public class FinancialAccountingApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinancialAccountingApplication.class, args);
        log.info("Time zone is set to {}", System.getProperty("user.timezone"));
        log.info("Date time is: {}", LocalDateTime.now());
    }
}
