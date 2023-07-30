package de.yggdrasil.core.dal.responses;

import de.yggdrasil.core.dal.DALResponse;

public class DALConfigResponse implements DALResponse<String> {

    private final String data;

    public DALConfigResponse(String data) {
        this.data = data;
    }

    @Override
    public String getData() {
        return this.data;
    }

}
