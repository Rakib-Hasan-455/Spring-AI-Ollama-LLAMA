package com.springai.springaibyollama;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAiByOllamaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAiByOllamaApplication.class, args);
    }
}
