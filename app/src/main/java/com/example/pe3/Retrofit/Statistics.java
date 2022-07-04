package com.example.pe3.Retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Statistics {
    @SerializedName("cases")
    @Expose
    private String cases;

    @SerializedName("todayCases")
    @Expose
    private String todayCases;

    @SerializedName("deaths")
    @Expose
    private String deaths;

    public Statistics(
            String cases,
            String todayCases,
            String deaths
    ) {
        this.cases = cases;
        this.todayCases = todayCases;
        this.deaths = deaths;
    }

    String getCases() { return this.cases; }
    //void SetCases(String cases) { this.cases = cases; }
    String getTodayCases() { return this.todayCases; }
    String getDeaths() { return this.deaths; }

}
