package de.yggdrasil.core.dal.pipeline;

import de.yggdrasil.core.dal.DALResponse;
import de.yggdrasil.core.dal.data.DatasourceLibrary;
import de.yggdrasil.core.dal.data.datasources.PostgresDB;
import de.yggdrasil.core.dal.requests.DALConfigRequest;
import de.yggdrasil.core.dal.requests.DALReadRequest;
import de.yggdrasil.core.dal.requests.DALRequest;
import de.yggdrasil.core.dal.requests.DALWriteRequest;
import de.yggdrasil.core.dal.responses.DALConfigResponse;

import java.nio.charset.StandardCharsets;

public class DefaultConfigPipeline implements Pipeline {

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
        String configValue = new String(DatasourceLibrary.getDatasource(
                readRequest.getDatasource()).getBytes(readRequest.getIdentifier()), StandardCharsets.UTF_8);
        return new DALConfigResponse(configValue);
    }
}
