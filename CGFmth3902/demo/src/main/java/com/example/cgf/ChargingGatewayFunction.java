package com.example.cgf;

import java.sql.SQLException;
import java.util.Properties;

public class ChargingGatewayFunction {
    private KafkaPoller kafkaPoller;
    private OracleInserter oracleInserter;

    public ChargingGatewayFunction(Properties kafkaProps, String kafkaTopic, String dbUrl,
            String dbUser, String dbPassword) throws SQLException {
        this.kafkaPoller = new KafkaPoller(kafkaProps, kafkaTopic);
        this.oracleInserter = new OracleInserter(dbUrl, dbUser, dbPassword);
    }

    public void run() {
        while (true) {
            String message = kafkaPoller.pollMessage();
            if (message != null) {
                try {
                    oracleInserter.insertUsageRecord(message);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void shutdown() {
        kafkaPoller.close();
        try {
            oracleInserter.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", "localhost:9092");
        kafkaProps.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        kafkaProps.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        kafkaProps.put("group.id", "cgf-group");
        String kafkaTopic = "CGF";
        String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
        String dbUser = "username";
        String dbPassword = "password";
        try {
            ChargingGatewayFunction cgf =
                    new ChargingGatewayFunction(kafkaProps, kafkaTopic, dbUrl, dbUser, dbPassword);
            cgf.run();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
