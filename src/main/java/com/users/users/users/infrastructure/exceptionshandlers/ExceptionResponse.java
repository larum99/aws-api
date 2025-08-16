package com.users.users.users.infrastructure.exceptionshandlers;

import java.time.LocalDateTime;

public record ExceptionResponse(String message, LocalDateTime timeStamp) {
}

