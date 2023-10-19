package entities;

import enums.Sex;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private String email;
    private LocalDate birthday;
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @OneToMany(mappedBy = "person", cascade = CascadeType.REMOVE)
    private Set<Partecipazione> partecipazioni=new HashSet<>();


    public Persona(){}

    public Persona(String name, String surname, String email, LocalDate birthday, Sex sex) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthday = birthday;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", sex=" + sex +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Sex getSex() {
        return sex;
    }

    public Set<Partecipazione> getPartecipazioni() {
        return partecipazioni;
    }

    public void setPartecipazioni(Set<Partecipazione> partecipazioni) {
        this.partecipazioni = partecipazioni;
    }
}
