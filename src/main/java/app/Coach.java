package app;

public class Coach {
    private int id;
    private String name;
    private String surname;
    private String speciality_descr;
    private int speciality_id;

    public Coach() {
    }

    public Coach(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Coach(int id, String name, String surname, int speciality_id) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.speciality_id = speciality_id;
    }

    public Coach(String name, String surname, String speciality_descr) {
        this.name = name;
        this.surname = surname;
        this.speciality_descr = speciality_descr;
    }

    public Coach(String name, String surname, int speciality_id) {
        this.name = name;
        this.surname = surname;
        this.speciality_id = speciality_id;
    }

    public Coach(int id, String name, String surname, String speciality_descr, int speciality_id) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.speciality_descr = speciality_descr;
        this.speciality_id = speciality_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setSpeciality_descr(String speciality_descr) {
        this.speciality_descr = speciality_descr;
    }

    public void setSpeciality_id(int speciality_id) {
        this.speciality_id = speciality_id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getSpeciality_descr() {
        return speciality_descr;
    }

    public int getSpeciality_id() {
        return speciality_id;
    }

    @Override
    public String toString() {
        return "Coach name=" + name + ", surname=" + surname;
    }

}
