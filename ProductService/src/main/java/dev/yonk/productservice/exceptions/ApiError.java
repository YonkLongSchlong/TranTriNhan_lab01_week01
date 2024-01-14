package dev.yonk.productservice.exceptions;

import java.time.LocalDateTime;

public record ApiError(
        String path,
        String message,
        Throwable throwable,
        int statusCode,
        LocalDateTime localDateTime
) {
}
