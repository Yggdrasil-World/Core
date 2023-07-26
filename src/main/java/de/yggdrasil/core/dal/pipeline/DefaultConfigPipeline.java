package de.yggdrasil.core.dal.pipeline;

import de.yggdrasil.core.dal.DALResponse;
import de.yggdrasil.core.dal.requests.DALConfigRequest;
import de.yggdrasil.core.dal.requests.DALReadRequest;
import de.yggdrasil.core.dal.requests.DALRequest;
import de.yggdrasil.core.dal.requests.DALWriteRequest;

public class DefaultConfigPipeline implements Pipeline{

    @Override
    public Class<DALRequest>[] applyForRequestTypes() {
        return new Class[]{DALConfigRequest.class};
    }

    @Override
    public void writeBytes(DALWriteRequest writeRequest) {
        //TODO
    }

    @Override
    public DALResponse readBytes(DALReadRequest readRequest) {
        //TODO
        return null;
    }
}
