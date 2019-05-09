package Day07;

class Student {
    int number;
    int state;
    int score;

    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                ", state=" + state +
                ", score=" + score +
                '}';
    }
}

class StudentTest {
    public static void main(String[] args) {
        Student[] students = new Student[20];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
            students[i].number = i + 1;
            students[i].state = (int) (Math.random() * 5) + 1;
            students[i].score = (int) (Math.random() * 100) + 1;
        }

        for (int i = 0; i < students.length - 1; i++) {
            if (students[i].state == 3) {
                System.out.println(students[i].toString());
            }
        }
    }
}