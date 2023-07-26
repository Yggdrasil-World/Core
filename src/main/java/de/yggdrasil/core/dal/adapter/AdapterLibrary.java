package de.yggdrasil.core.dal.adapter;

import de.yggdrasil.core.exceptions.dal.DuplicateAdapterForClassException;

import java.util.HashMap;

public class AdapterLibrary {

    private final HashMap<Class, Adapter> adapters = new HashMap<>();

    {
        setup();
    }

    private void setup(){
        this.addAdapterCollection(new DefaultAdapterCollector());
    }

    public void addAdapterCollection(AdapterCollector collector){
        for (Class<? extends Adapter> adapterClass:
             collector.collectAdapters()) {
            this.addAdapter(adapterClass);
        }
        System.out.println(adapters.size());
    }

    private void addAdapter(Class<? extends Adapter> adapterClass){
        try {
            Adapter adapterInstance = adapterClass.newInstance();
            Class adapterType = adapterInstance.getClassOfAdapter();
            if (this.adapters.containsKey(adapterType)) throw new DuplicateAdapterForClassException();
            this.adapters.put(adapterType, adapterInstance);
        } catch (InstantiationException | IllegalAccessException | DuplicateAdapterForClassException e) {
            e.printStackTrace();
        }
    }

    public Adapter getAdapterForClass(Class c){
        return this.adapters.get(c);
    }

}
