package dtos;

import entities.Trip;

import java.util.Objects;

public class TripDTO {

    private Long id;
    private String name;
    private String time;
    private String location;
    private String duration;


    public TripDTO(Trip trip){
        this.name = trip.getName();
        this.time = trip.getTime();
        this.location = trip.getLocation();
        this.duration = trip.getDuration();
    }


    public TripDTO(String name, String time, String location, String duration) {
        this.name = name;
        this.time = time;
        this.location = location;
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripDTO tripDTO = (TripDTO) o;
        return Objects.equals(name, tripDTO.name) && Objects.equals(time, tripDTO.time) && Objects.equals(location, tripDTO.location) && Objects.equals(duration, tripDTO.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, time, location, duration);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }



}
