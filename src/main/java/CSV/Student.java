package CSV;

public class Student {
    private String marks;
    private String hobbies;
    private String gender;

    public Student(String marks, String hobbies, String gender) {
        this.marks = marks;
        this.hobbies = hobbies;
        this.gender = gender;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "marks=" + marks +
                ", hobbies='" + hobbies + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}

