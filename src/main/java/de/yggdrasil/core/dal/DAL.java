package de.yggdrasil.core.dal;

import java.util.HashMap;

public final class DAL {

    private final static DAL instance = new DAL();

    private final HashMap<String, Byte[]> data = new HashMap<>();

    private DAL (){}

    public void saveData(String identifier, Byte[] data){

    }

    public Byte[] readData(String identifier){
        return this.data.get(identifier);
    }

    public static DAL get(){
        return instance;
    }

}
