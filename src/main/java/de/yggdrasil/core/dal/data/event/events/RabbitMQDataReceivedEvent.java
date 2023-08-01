package de.yggdrasil.core.dal.data.event.events;

import de.yggdrasil.core.dal.data.DataSource;
import de.yggdrasil.core.dal.data.network.rabbitmq.RabbitMQMessage;

public class RabbitMQDataReceivedEvent implements DataReceivedEvent{

    private final DataSource dataSource;
    private final RabbitMQMessage message;

    public RabbitMQDataReceivedEvent(DataSource dataSource, RabbitMQMessage message){
        this.dataSource = dataSource;
        this.message = message;
    }

    @Override
    public DataSource getSource() {
        return this.dataSource;
    }

    public RabbitMQMessage getMessage() {
        return message;
    }

}
