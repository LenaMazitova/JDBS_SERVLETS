package app;

public class Speciality {
    private int id;

    private String description;

    public Speciality() {
    }

    public Speciality(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public Speciality(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Speciality [id=" + id + ", description=" + description + "]";
    }
}
