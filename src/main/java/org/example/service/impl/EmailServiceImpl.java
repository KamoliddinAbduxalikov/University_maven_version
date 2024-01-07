package org.example.service.impl;

import org.example.service.EmailService;

public class EmailServiceImpl implements EmailService {

    @Override
    public void addEmailHistory(String email, Integer msg) {
        EMAIL_HISTORY_MAP.put(email,msg);
    }
}
