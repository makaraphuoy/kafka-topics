## Console command-line for testing sending topic

```bash 

winpty docker exec -it kafka-topic-kafka-1 kafka-console-producer.sh --broker-list localhost:9092 --topic kafka-topic

```


```bash 

winpty docker exec -it kafka-topic-kafka-1 kafka-console-producer.sh --broker-list localhost:9092 --topic kafka-topic --property parse.key=true --property key.separator=:

```


## Reference

[GeeksforGeeks](https://www.geeksforgeeks.org/subscribe-to-the-topic-in-apache-kafka-from-java-application/)

[GeeksforGeeks](https://www.geeksforgeeks.org/how-to-setup-kafka-on-docker/?ref=header_outind)