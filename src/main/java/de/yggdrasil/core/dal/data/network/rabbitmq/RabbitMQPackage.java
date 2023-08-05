package de.yggdrasil.core.dal.data.network.rabbitmq;

import de.yggdrasil.core.dal.data.network.Package;
import de.yggdrasil.core.utils.ByteUtils;

import java.nio.ByteBuffer;

public class RabbitMQPackage implements Package {

    private final byte[] header;
    private final byte[] data;

    public RabbitMQPackage(RabbitMQMessage message){
        header = ByteBuffer.allocate(4).putInt(message.key().length()).array();
        data = ByteUtils.connectByteArrays(message.key().getBytes(), message.content());
    }

    @Override
    public byte[] toBytes() {
        return ByteUtils.connectByteArrays(header, data);
    }


}
