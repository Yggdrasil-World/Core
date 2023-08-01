package de.yggdrasil.core.dal.adapter;

@DALAdapter
public interface Adapter<T> {

    byte[] convertToData(T object);

    T createFromData(byte[] data);

    Class<T> getClassOfAdapter();

}
