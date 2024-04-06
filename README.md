## Message Processor

1. Clone the project
2. It is built using Java 21, Spring boot
3. Navigate to src/main/InnovApplication.java class
4. Run the class
5. App would start on port http://localhost:8080
6. It has one POST API call   - http://localhost:8080/push
7. Request body should be like {
    "content": "kallol",
    "processor": "MessageProcessor1"
}
8. Currently the app supports 2 MessageProcessors- MessageProcessor1 and MessageProcessor2
9. Depending on the choice of message processor, it will process the request accordingly

![img_1.png](src%2Fmain%2Fresources%2Fstatic%2Fimg_1.png)
![img.png](src%2Fmain%2Fresources%2Fstatic%2Fimg.png)