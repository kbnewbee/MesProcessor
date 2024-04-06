package com.kaybee.innov.controller;

import com.kaybee.innov.model.Message;
import com.kaybee.innov.service.MessageProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageHandler {

  @Autowired
  private MessageProcessorService messageProcessorService;

  @PostMapping("/push")
  public void submitMessage(@RequestBody Message message) {
    messageProcessorService.submitMessage(message);
  }

}
