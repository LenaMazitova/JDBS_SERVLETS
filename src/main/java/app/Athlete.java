package app;

public class Athlete {
    private int id;
    private String name;
    private String surname;
    private Coach coach;
    private int coach_id;

    public Athlete() {
    }

    public Athlete(int id, String name, String surname, Coach coach, int coach_id) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.coach = coach;
        this.coach_id = coach_id;
    }

    public Athlete(int id, String name, String surname, int coach_id) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.coach_id = coach_id;
    }

    public Athlete(String name, String surname, Coach coach) {
        this.name = name;
        this.surname = surname;
        this.coach = coach;
    }

    public Athlete(String name, String surname, int coach_id) {
        this.name = name;
        this.surname = surname;
        this.coach_id = coach_id;
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

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public void setCoach_id(int coach_id) {
        this.coach_id = coach_id;
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

    public Coach getCoach() {
        return coach;
    }

    public int getCoach_id() {
        return coach_id;
    }

    @Override
    public String toString() {
        return "Athlete [id=" + id + ", name=" + name + ", surname=" + surname + ", coach_id="
                + coach_id + ", coach= [" + coach.toString() + "] ]";
    }

}
