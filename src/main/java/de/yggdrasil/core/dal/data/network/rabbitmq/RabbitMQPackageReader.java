package de.yggdrasil.core.dal.data.network.rabbitmq;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class RabbitMQPackageReader {

    public static RabbitMQMessage readPackage(byte[] packageData){
        byte[] header = Arrays.copyOfRange(packageData, 0, 5);
        int keySize = ByteBuffer.wrap(header).getInt();
        byte[] key = Arrays.copyOfRange(packageData, 5, keySize);
        return new RabbitMQMessage(new String(key),
                Arrays.copyOfRange(packageData, keySize, packageData.length+1));
    }

}
