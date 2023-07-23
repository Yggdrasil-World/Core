package de.yggdrasil.core.dal;

import de.yggdrasil.core.dal.adapter.Adapter;
import de.yggdrasil.core.dal.adapter.AdapterLibrary;
import de.yggdrasil.core.dal.adapter.DALAdapter;

public class DALPipeline {

    private final AdapterLibrary libary = new AdapterLibrary();
    private final DataManager dataManager = new DataManager();

    protected DALPipeline() {
    }

    protected <T> void saveData(String identifier, T object) {
        byte[] data = this.libary.getAdapterForClass(object.getClass())
                .stream()
                .findFirst()
                .get()
                .convertToData(object);
        this.dataManager.saveData(identifier, data);
    }

    protected <T> T loadData(String identifier) {
        DALEntry entry = this.dataManager.getData(identifier);
        return (T) this.libary.getAdapterForClass(entry.objectClass()).stream().findFirst().get()
                .createFromData(entry.data());
    }

}
