package de.yggdrasil.core.dal;

import de.yggdrasil.core.dal.adapter.Adapter;
import de.yggdrasil.core.dal.adapter.AdapterLibary;
import de.yggdrasil.core.dal.adapter.DALAdapter;

public class DALPipeline {

    private final AdapterLibary libary = new AdapterLibary();
    private final DataManager dataManager = new DataManager();

    protected DALPipeline(){

    }

    protected <T> void saveData(String identifier, Class<? extends Adapter<T>> adapterClass, T object){
        byte[] data = this.libary.getAdapter(
                adapterClass.getAnnotation(DALAdapter.class).identifier())
                .convertToData(object);
        this.dataManager.saveData(identifier, data);
    }

    protected <T> T loadData(String identifier, Class<? extends Adapter<T>> adapterClass){
        byte[] data = this.dataManager.getData(identifier);
        return (T) this.libary.getAdapter(
                adapterClass.getAnnotation(DALAdapter.class).identifier())
                .createFromData(data);
    }

}
