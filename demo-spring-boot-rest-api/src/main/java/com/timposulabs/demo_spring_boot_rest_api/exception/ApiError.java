package com.timposulabs.demo_spring_boot_rest_api.exception;

import java.time.LocalDateTime;

public record ApiError(
        String error,
        String path,
        int status,
        LocalDateTime timestamp) {
}
