package de.yggdrasil.core.dal.data.datasources;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import de.yggdrasil.core.Main;
import de.yggdrasil.core.dal.data.DALWriteScope;
import de.yggdrasil.core.dal.data.EventDataSource;
import de.yggdrasil.core.dal.data.HideFromDefaultCollector;
import de.yggdrasil.core.dal.data.event.DALDefaultEventBus;
import de.yggdrasil.core.dal.data.event.DALEventbus;
import de.yggdrasil.core.dal.data.event.DataSourceDataListener;
import de.yggdrasil.core.dal.data.event.events.RabbitMQDataReceivedEvent;
import de.yggdrasil.core.dal.data.network.rabbitmq.RabbitMQMessage;
import de.yggdrasil.core.dal.data.network.rabbitmq.RabbitMQPackage;
import de.yggdrasil.core.dal.data.network.rabbitmq.RabbitMQPackageReader;
import net.minestom.server.utils.ArrayUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;
import java.util.stream.Stream;

@HideFromDefaultCollector
public class RabbitMQ implements EventDataSource {

    private final String queueName;
    private byte[] lastMessage;
    private Channel channel;
    private DALEventbus eventbus = new DALDefaultEventBus();

    private DeliverCallback callback = (consumerTag, delivery) -> {
        RabbitMQMessage message = RabbitMQPackageReader.readPackage(delivery.getBody());
        this.eventbus.triggerEvent(new RabbitMQDataReceivedEvent(this, message));
    };

    public RabbitMQ(String queueName){
        this.queueName = queueName;
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(Main.dotenv.get("RABBIT_MQ_HOST"));
        connectionFactory.setPort(Integer.parseInt(Main.dotenv.get("RABBIT_MQ_PORT")));
        try {
            Connection connection = connectionFactory.newConnection();
            channel = connection.createChannel();
            channel.queueDeclare(queueName, false, false, false, null);
            channel.basicConsume(queueName, true, callback, consumerTag -> {});
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }

    @Override
    public DALWriteScope[] getSupportedWriteScopes() {
        return new DALWriteScope[]{DALWriteScope.RUNTIME_SYNCHRONISED};
    }

    @Override
    public byte[] getBytes(String identifier) {
        return lastMessage;
    }

    @Override
    public void writeBytes(String key, byte[] value) {
        try {
            this.channel.basicPublish("", queueName, null,
                    new RabbitMQPackage(new RabbitMQMessage(key, value)).toBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void registerEventListener(DataSourceDataListener listener) {
        this.eventbus.registerListener(listener);
    }

    @Override
    public DALEventbus getEventBus() {
        return this.eventbus;
    }

}
