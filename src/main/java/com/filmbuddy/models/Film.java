package com.filmbuddy.models;
import java.sql.Timestamp;

public class Film {
    private int film_id;
    private String title;
    private int actor_id;
    private String first_name;
    private String last_name;
  
    private Timestamp last_update;
    
    public int getActor_id() {
    	return actor_id;
    }
    public void setActor_id(int actor_id) {
    	this.actor_id = actor_id;
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
    
    public int getFilm_id() {
    	return film_id;
    }
    public void setFilm_id(int film_id) {
    	this.film_id = film_id;
    }
    public String getTitle() {
    	return title;
    }
    public void setTitle(String title) {
    	this.title = title;
    }
    public Timestamp getLast_update() {
    	return last_update;
    }
    public void setLast_update(Timestamp last_update) {
    	this.last_update = last_update;
    }
}
