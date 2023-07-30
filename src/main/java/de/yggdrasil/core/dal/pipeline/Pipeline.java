package de.yggdrasil.core.dal.pipeline;

import de.yggdrasil.core.dal.DALResponse;
import de.yggdrasil.core.dal.requests.DALReadRequest;
import de.yggdrasil.core.dal.requests.DALRequest;
import de.yggdrasil.core.dal.requests.DALWriteRequest;

@DALPipeline
public interface Pipeline {

    Class<DALRequest>[] applyForRequestTypes();

    public void writeBytes(DALWriteRequest writeRequest);

    public DALResponse readBytes(DALReadRequest readRequest);

}
