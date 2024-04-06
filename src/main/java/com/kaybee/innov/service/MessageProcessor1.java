package com.kaybee.innov.service;

import com.kaybee.innov.model.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageProcessor1 implements IMessageProcessor {

  @Override
  public void processMessage(Message message) {
    System.out.println(
        "Processing message from processor 1: " + message.getContent() + " in thread: " + Thread.currentThread()
            .getName());
  }
}
