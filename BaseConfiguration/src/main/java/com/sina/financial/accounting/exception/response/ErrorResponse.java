package com.sina.financial.accounting.exception.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;


public record ErrorResponse(
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'hh:mm:ss")
        LocalDateTime timestamp,
        String status,
        String error,
        String message,
        String path,
        Object customMessage
) {
}
