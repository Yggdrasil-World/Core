package de.yggdrasil.core.dal.data.network.rabbitmq;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class RabbitMQPackageReader {

    public static RabbitMQMessage readPackage(byte[] packageData){
        byte[] header = Arrays.copyOfRange(packageData, 0, 4);
        int keySize = ByteBuffer.wrap(header).getInt();
        byte[] key = Arrays.copyOfRange(packageData, 4, 4 + keySize);
        return new RabbitMQMessage(new String(key),
                Arrays.copyOfRange(packageData, keySize + 4, packageData.length));
    }

}
