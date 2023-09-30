package com.example.individualproject.models;

public class ShadowProfile {
    public ShadowProfile(int id, String first_name, String last_name, String pseudonym, String profile_pic_url, int collection_id) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.pseudonym = pseudonym;
        this.profile_pic_url = profile_pic_url;
        this.collection_id = collection_id;
    }

    private int id;
    private String first_name;
    private String last_name;
    private String pseudonym;
    private String profile_pic_url;
    private int collection_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    public String getProfile_pic_url() {
        return profile_pic_url;
    }

    public void setProfile_pic_url(String profile_pic_url) {
        this.profile_pic_url = profile_pic_url;
    }

    public int getCollection_id() {
        return collection_id;
    }

    public void setCollection_id(int collection_id) {
        this.collection_id = collection_id;
    }
}
