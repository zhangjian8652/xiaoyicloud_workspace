package com.test.retrofit.domain;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangjian on 2016/10/18.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "weatherinfo"
})
public class Example {

    @JsonProperty("weatherinfo")
    private Weatherinfo weatherinfo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The weatherinfo
     */
    @JsonProperty("weatherinfo")
    public Weatherinfo getWeatherinfo() {
        return weatherinfo;
    }

    /**
     *
     * @param weatherinfo
     * The weatherinfo
     */
    @JsonProperty("weatherinfo")
    public void setWeatherinfo(Weatherinfo weatherinfo) {
        this.weatherinfo = weatherinfo;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Example{" +
                "weatherinfo=" + weatherinfo +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
