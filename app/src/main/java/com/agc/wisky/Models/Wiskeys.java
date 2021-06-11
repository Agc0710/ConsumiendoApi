package com.agc.wisky.Models;

import com.google.gson.annotations.SerializedName;


public class Wiskeys {
    @SerializedName("slug")
    private String slugWiskey;

    @SerializedName("name")
    private String NombreWiskey;

    @SerializedName("Base_currency")
    private String MonedaBase;

    @SerializedName("url")
    private String Url;

    @SerializedName("dt")
    private String Date;

    @SerializedName("auction_trading_volume")
    private String volumenComercio;

    public String getMonedaBase() {
        return MonedaBase;
    }

    public void setMonedaBase(String monedaBase) {
        MonedaBase = monedaBase;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) { Url = url;
    }

    public String getDate() { return Date;
    }

    public void setDate(String date) { Date = date;
    }

    public String getVolumenComercio() { return volumenComercio;
    }

    public void setVolumenComercio(String volumenComercio) { this.volumenComercio = volumenComercio;
    }

    public String getSlugWiskey() {
        return slugWiskey;
    }

    public void setSlugWiskey(String slugWiskey) {
        this.slugWiskey = slugWiskey;
    }

    public String getNombreWiskey() {
        return NombreWiskey;
    }
    public void setNombreWiskey(String nombreWiskey) {
        NombreWiskey = nombreWiskey;
    }


}
