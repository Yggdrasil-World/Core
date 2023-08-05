package de.yggdrasil.core.dal.pipeline;

import de.yggdrasil.core.dal.responses.DALResponse;
import de.yggdrasil.core.dal.requests.DALReadRequest;
import de.yggdrasil.core.dal.requests.DALRequest;
import de.yggdrasil.core.dal.requests.DALWriteRequest;

@DALPipeline
public interface Pipeline {

    Class<DALRequest>[] applyForRequestTypes();

    void writeBytes(DALWriteRequest writeRequest);

    DALResponse readBytes(DALReadRequest readRequest);

}
