package zuo.class_03;

import java.util.Comparator;
import java.util.PriorityQueue;

class Student {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.id + ": " + this.name;
    }
}

class NameComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }
}

class IdComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.id - o2.id;
    }
}

public class Code_01_Comparator {

    public static void main(String[] args) {
        Student s1 = new Student(1, "zhangsan");
        Student s2 = new Student(2, "lisi");
        Student s3 = new Student(5, "wangwu");

        // PriorityQueue<Student> p = new PriorityQueue<>(new NameComparator());
        PriorityQueue<Student> p = new PriorityQueue<>(new IdComparator());
        p.add(s1);
        p.add(s2);
        p.add(s3);

        while (!p.isEmpty()) {
            Student student = p.poll();
            System.out.println(student);
        }
    }

}
