package com.example.demo.test.base.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Description
 * @Date 2020/5/26 18:23
 * @Author cly
 **/
@Getter
@Setter
public class Album {
    private String name;
    private List<Track> tracks;
    private List<Artist> musicians;
    public Album(String name,List<Track> tracks,List<Artist> musicians){
        this.musicians=musicians;
        this.name=name;
        this.tracks=tracks;
    }
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<Track> getTracks() {
//        return tracks;
//    }
//
//    public void setTracks(List<Track> tracks) {
//        this.tracks = tracks;
//    }
//
//    public List<Artist> getMusicians() {
//        return musicians;
//    }
//
//    public void setMusicians(List<Artist> musicians) {
//        this.musicians = musicians;
//    }
}
