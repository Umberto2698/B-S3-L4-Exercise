package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String city;
    @OneToMany(mappedBy = "location", cascade = CascadeType.REMOVE)
    private List<Evento> events=new ArrayList<>();

    public Location(){}

    public Location(String name, String city) {
        this.name = name;
        this.city = city;
    }


    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public List<Evento> getEvents() {
        return events;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
