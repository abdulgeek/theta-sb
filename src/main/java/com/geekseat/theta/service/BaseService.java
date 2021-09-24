package com.geekseat.theta.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geekseat.theta.model.BaseModel;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class BaseService {

    ObjectMapper mapper = new ObjectMapper();

    public void toDecorate(BaseModel entity) throws JsonProcessingException {
        if (entity == null) {
            return;
        }
        if (entity.getMap() != null) {
            entity.setMapData(mapper.writeValueAsString(entity.getMap()));
        }
    }

    public void fromDecorate(BaseModel entity) throws JsonProcessingException {
        if (entity == null) {
            return;
        }
        if (entity.getMapData() != null && !entity.getMapData().isEmpty()) {
            entity.setMap(mapper.readValue(entity.getMapData(), HashMap.class));
        }
    }

}
