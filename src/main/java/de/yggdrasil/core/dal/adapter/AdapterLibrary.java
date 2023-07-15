package de.yggdrasil.core.dal.adapter;

import de.yggdrasil.core.exceptions.IdentifierAlreadyExistsException;

import java.util.HashMap;
import java.util.Set;

public class AdapterLibrary {

    private final HashMap<String, Adapter> adapters = new HashMap<>();

    {
        setup();
    }

    private void setup(){
        Set<Class<Adapter>> adapterClasses = AdapterCollector.findAdapters();
        for (Class<Adapter> adapterClass:
             adapterClasses) {
            try {
                String identifier = adapterClass.getAnnotation(DALAdapter.class).identifier();
                if (this.adapters.containsKey(identifier)) throw new IdentifierAlreadyExistsException(identifier);
                this.adapters.put(identifier, adapterClass.newInstance());
            } catch (InstantiationException | IllegalAccessException | IdentifierAlreadyExistsException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Adapter getAdapter(String identifier){
        return adapters.get(identifier);
    }

}
