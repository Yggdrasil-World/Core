package de.yggdrasil.core.dal;

import de.yggdrasil.core.dal.adapter.Adapter;

import java.util.HashMap;

public final class DAL {

    private final static DAL instance = new DAL();
    private final DALPipeline pipeline = new DALPipeline();

    private DAL (){}

    public <T> void saveData(String identifier, T object){
        this.pipeline.saveData(identifier, object);
    }

    public <T> T readData(String identifier){
        return this.pipeline.loadData(identifier);
    }

    public static DAL get(){
        return instance;
    }

}
