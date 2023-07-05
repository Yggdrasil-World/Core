package de.yggdrasil.core.dal.adapter;

public interface Adapter {

    public <T> byte[] convertToData(T object);

    public <T> T createFromData(byte[] data);

}
