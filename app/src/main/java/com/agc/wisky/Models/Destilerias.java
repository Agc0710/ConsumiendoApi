package com.agc.wisky.Models;

import com.google.gson.annotations.SerializedName;

public class Destilerias {

    @SerializedName("name")
    private String NombreDestileria;

    @SerializedName("slug")
    private String slugDestileria;

    @SerializedName("country")
    private String countryDestileria;

    @SerializedName("dt")
    private String fecha;

    @SerializedName("lots_count")
    private String Lotes;

    @SerializedName("winning_bid_max")
    private String winning_bid_max;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLotes() {
        return Lotes;
    }

    public void setLotes(String lotes) {
        Lotes = lotes;
    }

    public String getWinning_bid_max() {
        return winning_bid_max;
    }

    public void setWinning_bid_max(String winning_bid_max) {
        this.winning_bid_max = winning_bid_max;
    }

    public String getNombreDestileria() { return NombreDestileria;
    }

    public void setNombreDestileria(String nombreDestileria) { NombreDestileria = nombreDestileria;
    }

    public String getSlugDestileria() { return slugDestileria;
    }

    public void setSlugDestileria(String slugDestileria) { this.slugDestileria = slugDestileria;
    }

    public String getCountryDestileria() { return countryDestileria;
    }

    public void setCountryDestileria(String countryDestileria) { this.countryDestileria = countryDestileria;
    }
}
