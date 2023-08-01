package de.yggdrasil.core.utils;

public class ByteUtils {

    public static byte[] connectByteArrays(byte[] arrayA, byte[] arrayB){
        byte[] result = new byte[arrayA.length+arrayB.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = i < arrayA.length ? arrayA[i] : arrayB[i-arrayA.length];
        }
        return result;
    }

}
