package com.kaybee.innov.service;

import com.kaybee.innov.model.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageProcessor2 implements IMessageProcessor {

  @Override
  public void processMessage(Message message) {
    System.out.println(
        "Processing message from processor 2: " + message.getContent() + " in thread: " + Thread.currentThread()
            .getName());
  }
}
