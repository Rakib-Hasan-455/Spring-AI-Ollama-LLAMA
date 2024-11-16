package com.springai.springaibyollama.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @GetMapping("/chat")
    public String getChatPage() {
        return "<!DOCTYPE html>" +
                "<html lang='en'>" +
                "<head>" +
                "    <meta charset='UTF-8'>" +
                "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
                "    <title>AI Chat</title>" +
                "    <script src='https://code.jquery.com/jquery-3.6.0.min.js'></script>" +
                "    <style>" +
                "        body { font-family: Arial, sans-serif; margin: 0; padding: 0; background-color: #f4f4f9; }" +
                "        #chat-container { max-width: 650px; margin: 20px auto; padding: 20px; background: #ffffff; border-radius: 8px; box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); }" +
                "        #messages { height: 800px; overflow-y: auto; border: 1px solid #ddd; border-radius: 5px; padding: 10px; margin-bottom: 10px; background: #f9f9f9; }" +
                "        .message { margin: 5px 0; padding: 8px 12px; border-radius: 5px; }" +
                "        .user-message { background: #d1e7dd; align-self: flex-end; }" +
                "        .bot-message { background: #f8d7da; }" +
                "        #input-container { display: flex; }" +
                "        #message-input { flex: 1; padding: 10px; border: 1px solid #ddd; border-radius: 5px; }" +
                "        #send-button { padding: 10px 20px; margin-left: 10px; border: none; border-radius: 5px; background: #007bff; color: white; cursor: pointer; }" +
                "        #send-button:hover { background: #0056b3; }" +
                "    </style>" +
                "</head>" +
                "<body>" +
                "    <div id='chat-container'>" +
                "        <div id='messages'></div>" +
                "        <div id='input-container'>" +
                "            <input type='text' id='message-input' placeholder='Type your message...' />" +
                "            <button id='send-button'>Send</button>" +
                "        </div>" +
                "    </div>" +
                "    <script>" +
                "        $(document).ready(function () {" +
                "            const apiUrl = 'http://localhost:8080/v1/ai/generate';" +
                "            function appendMessage(message, type) {" +
                "                const messageElement = $('<div>').addClass('message').addClass(type === 'user' ? 'user-message' : 'bot-message').text(message);" +
                "                $('#messages').append(messageElement);" +
                "                $('#messages').scrollTop($('#messages')[0].scrollHeight);" +
                "            }" +
                "            $('#send-button').on('click', function () {" +
                "                const userMessage = $('#message-input').val().trim();" +
                "                if (!userMessage) return;" +
                "                appendMessage(userMessage, 'user');" +
                "                $('#message-input').val('');" +
                "                $.ajax({" +
                "                    url: apiUrl," +
                "                    method: 'GET'," +
                "                    data: { message: userMessage }," +
                "                    success: function (response) {" +
                "                        appendMessage(response.generation, 'bot');" +
                "                    }," +
                "                    error: function (error) {" +
                "                        console.error('Error:', error);" +
                "                        appendMessage('Error: Unable to fetch response from the server.', 'bot');" +
                "                    }" +
                "                });" +
                "            });" +
                "            $('#message-input').on('keypress', function (e) {" +
                "                if (e.which === 13) {" +
                "                    $('#send-button').click();" +
                "                }" +
                "            });" +
                "        });" +
                "    </script>" +
                "</body>" +
                "</html>";
    }
}
