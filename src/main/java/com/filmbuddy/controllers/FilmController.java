package com.filmbuddy.controllers;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.filmbuddy.models.Film;

@RequestMapping("/films")
@Controller
public class FilmController {
	   @Value("${spring.datasource.url}")
	    private String url;

	    @Value("${spring.datasource.username}")
	    private String username;

	    @Value("${spring.datasource.password}")
	    private String password;
    
@GetMapping()
    public String getAllfilms(Model model) {
    	List<Film> films = new ArrayList<Film>();
    
    Connection con;
    try {
        con = DriverManager.getConnection(url, username, password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM  film join film_actor USING (film_id) JOIN actor USING (actor_id) ");
        while (rs.next()) {
            // create a new Film object
            Film newFilm = new Film();
            
            newFilm.setFilm_id(rs.getInt("film_id"));
            newFilm.setTitle(rs.getString("title"));
            newFilm.setActor_id(rs.getInt("actor_id"));
            newFilm.setFirst_name(rs.getString("first_name"));
            newFilm.setLast_name(rs.getString("last_name"));
            newFilm.setLast_update(rs.getTimestamp("last_update"));

            
            films.add(newFilm);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    System.out.println("something");
    model.addAttribute("films", films);
    return "films";
       
    }
}
