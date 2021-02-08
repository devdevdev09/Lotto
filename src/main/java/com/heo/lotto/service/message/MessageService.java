package com.heo.lotto.service.message;

import org.springframework.http.HttpStatus;

public interface MessageService {
    public HttpStatus sendMessage(String msg);
}
