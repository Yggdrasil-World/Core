package de.yggdrasil.core.dal.data;
import java.util.HashMap;

public class DatasourceLibrary {

    private final HashMap<Class, DataSource> dataSources = new HashMap<>();
    private final static DatasourceLibrary instance = new DatasourceLibrary();

    {
        setup();
    }

    private void setup(){
        this.addDatasourceCollection(new DefaultDatasourceCollector());
    }

    public void addDatasourceCollection(DatasourceCollector collector){
        for (Class<? extends DataSource> datasourceClass:
                collector.collectDatasources()) {
            this.addDatasource(datasourceClass);
        }
    }

    private void addDatasource(Class<? extends DataSource> datasourceClass){
        try {
            DataSource datasourceInstance = datasourceClass.newInstance();
            this.dataSources.put(datasourceClass, datasourceInstance);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public DataSource getDatasource(Class<? extends DataSource> datasourceClass){
        return dataSources.get(datasourceClass);
    }

    public static DatasourceLibrary get() {
        return instance;
    }

}
