package de.yggdrasil.core.dal.adapter;

import java.util.Set;

public interface AdapterCollector {

    public Set<Class<? extends Adapter>> collectAdapters();

}
