package com.kaybee.innov.controller;

import com.kaybee.innov.model.Message;
import com.kaybee.innov.service.MessageProcessorService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageHandler {

  @Autowired
  private MessageProcessorService messageProcessorService;

  @PostMapping("/push")
  public ResponseEntity<String> submitMessage(@RequestBody Message message) {
    try {
      messageProcessorService.submitMessage(message);
    } catch (Exception e) {
      System.out.println(e);
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    return ResponseEntity.status(HttpStatus.ACCEPTED).body("Message is successfully processed");
  }

  @PostMapping("/push")
  public ResponseEntity<String> submitMessageArray(@RequestBody ArrayList<Message> messageA) {
    try {
      messageProcessorService.submitMessageArray(messageA);
    } catch (Exception e) {
      System.out.println(e);
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    return ResponseEntity.status(HttpStatus.ACCEPTED).body("Message is successfully processed");
  }

}
