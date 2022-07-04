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

    @SerializedName("todayDeaths")
    @Expose
    private String todayDeaths;

    @SerializedName("recovered")
    @Expose
    private String recovered;

    @SerializedName("todayRecovered")
    @Expose
    private String todayRecovered;

    public Statistics(
            String cases,
            String todayCases,
            String deaths,
            String todayDeaths,
            String recovered,
            String todayRecovered
    ) {
        this.cases = cases;
        this.todayCases = todayCases;
        this.deaths = deaths;
        this.todayDeaths = todayDeaths;
        this.recovered = recovered;
        this.todayRecovered = todayRecovered;
    }

    String getCases() { return this.cases; }
    String getTodayCases() { return this.todayCases; }
    String getDeaths() { return this.deaths; }
    String getTodayDeaths() { return this.todayDeaths; }
    String getRecovered() { return this.recovered; }
    String getTodayRecovered() { return this.todayRecovered; }

}
