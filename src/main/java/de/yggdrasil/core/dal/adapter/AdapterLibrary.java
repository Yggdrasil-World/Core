package de.yggdrasil.core.dal.adapter;

import java.util.HashMap;
import java.util.Set;

public class AdapterLibrary {

    private final HashMap<Class, Set<Adapter>> adapters = new HashMap<>();

    {
        setup();
    }

    private void setup(){
        Set<Class<Adapter>> adapterClasses = AdapterCollector.findAdapters();
        for (Class<Adapter> adapterClass:
             adapterClasses) {
            try {
                Class adapterType = adapterClass.getAnnotation(DALAdapter.class).adapterForClass();
                if (this.adapters.get(adapterType).contains(adapterClass)) continue;
                this.adapters.get(adapterType).add(adapterClass.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Set<Adapter> getAdapterForClass(Class c){
        return this.adapters.get(c);
    }

}
