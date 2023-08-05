package de.yggdrasil.core.dal.adapter;

import java.util.Set;

public interface AdapterCollector {

    Set<Class<? extends Adapter>> collectAdapters();

}
