package de.yggdrasil.core.dal;

import de.yggdrasil.core.dal.adapter.Adapter;

import java.util.HashMap;

public final class DAL {

    private final static DAL instance = new DAL();
    private final DALPipeline pipeline = new DALPipeline();

    private final HashMap<String, Byte[]> data = new HashMap<>();

    private DAL (){}

    public <T> void saveData(String identifier, Class<? extends Adapter<T>> adapterClass, T object){
        this.pipeline.saveData(identifier, adapterClass, object);
    }

    public <T> T readData(String identifier, Class<? extends Adapter<T>> adapterClass){
        return this.pipeline.loadData(identifier, adapterClass);
    }

    public static DAL get(){
        return instance;
    }

}
