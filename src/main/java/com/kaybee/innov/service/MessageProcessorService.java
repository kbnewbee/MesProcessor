package com.kaybee.innov.service;

import com.kaybee.innov.model.Message;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import org.springframework.stereotype.Service;

@Service
public class MessageProcessorService {

  private final BlockingQueue<Message> messageQueue = new LinkedBlockingQueue<>();

  private final Executor executor = Executors.newFixedThreadPool(4);

  private IMessageProcessor iMessageProcessor;

  public MessageProcessorService() {
    startProcessing();
  }

  private void startProcessing() {
    for (int i = 0; i < 4; i++) {
      executor.execute(() -> {
        while (true) {
          try {
            Message message = messageQueue.take();
            iMessageProcessor.processMessage(message);
            //messageProcessor.processMessage(message);
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }
        }
      });
    }
  }

  public void submitMessage(Message message) {
    try {

      allocateMessageProcessor(message.getProcessor());

      messageQueue.put(message);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  public void allocateMessageProcessor(String mesPros) {
    if(mesPros.equals("MessageProcessor1")){
      this.iMessageProcessor = new MessageProcessor1();
    }else if(mesPros.equals("MessageProcessor2")){
      this.iMessageProcessor = new MessageProcessor2();
    }

  }
}
