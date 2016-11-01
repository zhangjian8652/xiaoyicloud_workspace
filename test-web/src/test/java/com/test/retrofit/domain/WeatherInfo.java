package com.test.retrofit.domain;
import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "city",
        "cityid",
        "temp",
        "WD",
        "WS",
        "SD",
        "WSE",
        "time",
        "isRadar",
        "Radar",
        "njd",
        "qy",
        "rain"
})
public class Weatherinfo {

    @JsonProperty("city")
    private String city;
    @JsonProperty("cityid")
    private String cityid;
    @JsonProperty("temp")
    private String temp;
    @JsonProperty("WD")
    private String wD;
    @JsonProperty("WS")
    private String wS;
    @JsonProperty("SD")
    private String sD;
    @JsonProperty("WSE")
    private String wSE;
    @JsonProperty("time")
    private String time;
    @JsonProperty("isRadar")
    private String isRadar;
    @JsonProperty("Radar")
    private String radar;
    @JsonProperty("njd")
    private String njd;
    @JsonProperty("qy")
    private String qy;
    @JsonProperty("rain")
    private String rain;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The city
     */
    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     * The city
     */
    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     * The cityid
     */
    @JsonProperty("cityid")
    public String getCityid() {
        return cityid;
    }

    /**
     *
     * @param cityid
     * The cityid
     */
    @JsonProperty("cityid")
    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    /**
     *
     * @return
     * The temp
     */
    @JsonProperty("temp")
    public String getTemp() {
        return temp;
    }

    /**
     *
     * @param temp
     * The temp
     */
    @JsonProperty("temp")
    public void setTemp(String temp) {
        this.temp = temp;
    }

    /**
     *
     * @return
     * The wD
     */
    @JsonProperty("WD")
    public String getWD() {
        return wD;
    }

    /**
     *
     * @param wD
     * The WD
     */
    @JsonProperty("WD")
    public void setWD(String wD) {
        this.wD = wD;
    }

    /**
     *
     * @return
     * The wS
     */
    @JsonProperty("WS")
    public String getWS() {
        return wS;
    }

    /**
     *
     * @param wS
     * The WS
     */
    @JsonProperty("WS")
    public void setWS(String wS) {
        this.wS = wS;
    }

    /**
     *
     * @return
     * The sD
     */
    @JsonProperty("SD")
    public String getSD() {
        return sD;
    }

    /**
     *
     * @param sD
     * The SD
     */
    @JsonProperty("SD")
    public void setSD(String sD) {
        this.sD = sD;
    }

    /**
     *
     * @return
     * The wSE
     */
    @JsonProperty("WSE")
    public String getWSE() {
        return wSE;
    }

    /**
     *
     * @param wSE
     * The WSE
     */
    @JsonProperty("WSE")
    public void setWSE(String wSE) {
        this.wSE = wSE;
    }

    /**
     *
     * @return
     * The time
     */
    @JsonProperty("time")
    public String getTime() {
        return time;
    }

    /**
     *
     * @param time
     * The time
     */
    @JsonProperty("time")
    public void setTime(String time) {
        this.time = time;
    }

    /**
     *
     * @return
     * The isRadar
     */
    @JsonProperty("isRadar")
    public String getIsRadar() {
        return isRadar;
    }

    /**
     *
     * @param isRadar
     * The isRadar
     */
    @JsonProperty("isRadar")
    public void setIsRadar(String isRadar) {
        this.isRadar = isRadar;
    }

    /**
     *
     * @return
     * The radar
     */
    @JsonProperty("Radar")
    public String getRadar() {
        return radar;
    }

    /**
     *
     * @param radar
     * The Radar
     */
    @JsonProperty("Radar")
    public void setRadar(String radar) {
        this.radar = radar;
    }

    /**
     *
     * @return
     * The njd
     */
    @JsonProperty("njd")
    public String getNjd() {
        return njd;
    }

    /**
     *
     * @param njd
     * The njd
     */
    @JsonProperty("njd")
    public void setNjd(String njd) {
        this.njd = njd;
    }

    /**
     *
     * @return
     * The qy
     */
    @JsonProperty("qy")
    public String getQy() {
        return qy;
    }

    /**
     *
     * @param qy
     * The qy
     */
    @JsonProperty("qy")
    public void setQy(String qy) {
        this.qy = qy;
    }

    /**
     *
     * @return
     * The rain
     */
    @JsonProperty("rain")
    public String getRain() {
        return rain;
    }

    /**
     *
     * @param rain
     * The rain
     */
    @JsonProperty("rain")
    public void setRain(String rain) {
        this.rain = rain;
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
        return "Weatherinfo{" +
                "city='" + city + '\'' +
                ", cityid='" + cityid + '\'' +
                ", temp='" + temp + '\'' +
                ", wD='" + wD + '\'' +
                ", wS='" + wS + '\'' +
                ", sD='" + sD + '\'' +
                ", wSE='" + wSE + '\'' +
                ", time='" + time + '\'' +
                ", isRadar='" + isRadar + '\'' +
                ", radar='" + radar + '\'' +
                ", njd='" + njd + '\'' +
                ", qy='" + qy + '\'' +
                ", rain='" + rain + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}