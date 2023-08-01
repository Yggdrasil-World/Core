package de.yggdrasil.core.dal.data.network.rabbitmq;

public record RabbitMQMessage(String key, byte[] content) { }
