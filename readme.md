#Console commandline for Testing
`` winpty docker exec -it kafka-topic-kafka-1 kafka-console-producer.sh --broker-list localhost:9092 --topic kafka-topic

``winpty docker exec -it kafka-topic-kafka-1 kafka-console-producer.sh --broker-list localhost:9092 --topic kafka-topic --property parse.key=true --property key.separator=:
