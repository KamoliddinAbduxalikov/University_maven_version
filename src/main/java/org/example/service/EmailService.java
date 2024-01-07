package org.example.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public interface EmailService {

    Map<String,Integer> EMAIL_HISTORY_MAP = Collections.synchronizedMap(new HashMap<>());

    void addEmailHistory(String email, Integer msg);
}
