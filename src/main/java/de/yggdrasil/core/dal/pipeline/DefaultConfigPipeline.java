package de.yggdrasil.core.dal.pipeline;

import de.yggdrasil.core.dal.responses.DALResponse;
import de.yggdrasil.core.dal.data.DatasourceLibrary;
import de.yggdrasil.core.dal.requests.*;
import de.yggdrasil.core.dal.responses.DALConfigResponse;

import java.nio.charset.StandardCharsets;

public class DefaultConfigPipeline implements Pipeline {

    @Override
    public Class<DALRequest>[] applyForRequestTypes() {
        return new Class[]{DALConfigReadRequest.class,DALConfigWriteRequest.class};
    }

    @Override
    public void writeBytes(DALWriteRequest writeRequest) {
        DALConfigWriteRequest dalConfigWriteRequest = (DALConfigWriteRequest) writeRequest;
        dalConfigWriteRequest.getDataSource().writeBytes(dalConfigWriteRequest.getKey(),dalConfigWriteRequest.getData().getBytes());
    }

    @Override
    public DALResponse readBytes(DALReadRequest readRequest) {
        String configValue = new String(DatasourceLibrary.get().getDatasource(
                readRequest.getDatasource()).getBytes(readRequest.getIdentifier()), StandardCharsets.UTF_8);
        return new DALConfigResponse(configValue);
    }
}
