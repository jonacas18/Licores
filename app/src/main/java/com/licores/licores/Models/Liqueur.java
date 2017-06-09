package com.licores.licores.Models;

public class Liqueur {
    private long liqueur_id;
    private String liqueur_type;
    private String liqueur_name;
    private String liqueur_size;
    private String liqueur_price;
    private String liqueur_description;

    public long getLiqueur_id() {
        return liqueur_id;
    }

    public Liqueur setLiqueur_id(long liqueur_id) {
        this.liqueur_id = liqueur_id;
        return this;
    }

    public String getLiqueur_type() {
        return liqueur_type;
    }

    public Liqueur setLiqueur_type(String liqueur_type) {
        this.liqueur_type = liqueur_type;
        return this;
    }

    public String getLiqueur_name() {
        return liqueur_name;
    }

    public Liqueur setLiqueur_name(String liqueur_name) {
        this.liqueur_name = liqueur_name;
        return this;
    }

    public String getLiqueur_size() {
        return liqueur_size;
    }

    public Liqueur setLiqueur_size(String liqueur_size) {
        this.liqueur_size = liqueur_size;
        return this;
    }

    public String getLiqueur_price() {
        return liqueur_price;
    }

    public Liqueur setLiqueur_price(String liqueur_price) {
        this.liqueur_price = liqueur_price;
        return this;
    }

    public String getLiqueur_description() {
        return liqueur_description;
    }

    public Liqueur setLiqueur_description(String liqueur_description) {
        this.liqueur_description = liqueur_description;
        return this;
    }
}
