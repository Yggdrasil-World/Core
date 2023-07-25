package de.yggdrasil.core.dal.adapter;

public interface Adapter<T> {

    byte[] convertToData(T object);

    T createFromData(byte[] data);

}
