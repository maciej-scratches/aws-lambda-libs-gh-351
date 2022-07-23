package com.example;

import com.amazonaws.lambda.thirdparty.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazonaws.lambda.thirdparty.com.fasterxml.jackson.databind.ObjectMapper;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.amazonaws.services.lambda.runtime.serialization.PojoSerializer;
import com.amazonaws.services.lambda.runtime.serialization.events.LambdaEventSerializers;
import com.amazonaws.services.lambda.runtime.serialization.factories.JacksonFactory;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        System.out.println("Hello world");

        String event = "{\n"
                + "    \"Records\": [\n"
                + "        {\n"
                + "            \"messageId\": \"83e95a89-bebc-4bbd-a209-181f6ab1110f\",\n"
                + "            \"receiptHandle\": \"...\",\n"
                + "            \"body\": \"...\",\n"
                + "            \"attributes\": {\n"
                + "                \"ApproximateReceiveCount\": \"1\",\n"
                + "                \"SentTimestamp\": \"1656267257645\",\n"
                + "                \"SenderId\": \"AIDAISDDSWNBEXIA6J64K\",\n"
                + "                \"ApproximateFirstReceiveTimestamp\": \"1656267257647\"\n"
                + "            },\n"
                + "            \"messageAttributes\": {},\n"
                + "            \"md5OfBody\": \"3154606fb27f5ffe194b5b97e3db3455\",\n"
                + "            \"eventSource\": \"aws:sqs\",\n"
                + "            \"eventSourceARN\": \"...\",\n"
                + "            \"awsRegion\": \"...\"\n"
                + "        }\n"
                + "    ]\n"
                + "}";

        PojoSerializer<SQSEvent> serializer = LambdaEventSerializers.serializerFor(SQSEvent.class,
                Main.class.getClassLoader());
        SQSEvent sqsEvent1 = serializer.fromJson(event);
        System.out.println(sqsEvent1);
    }
}
