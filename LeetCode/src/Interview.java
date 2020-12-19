import java.util.*;

/**
 * @author Alfalfa99
 * @version 1.0
 * @date 2020/12/19 18:24
 */
public class Interview {
    public static void main(String[] args) {
        StudentList sl = new StudentList();
        List<Student> list = sl.constructStudentList();
        System.out.println(sl.computeAverageScore(list));
    }
}

/* 请在这里填写答案
 * Student类的编程要求如下：

    成员变量包括：学生姓名(String name)、班级编码(String classCode)、分数(int score)
    根据程序需求编写构造方法。
    根据程序需求编写set和get方法。

StudentList类的编程要求如下：

    根据程序需求编写构造方法。
    constructStudentList方法：调用readInStudent方法读入多个学生信息，将Student对象添加到链表中，构建一个Student对象链表，最后返回链表。
    readInStudent方法：使用scanner从键盘读入一个学生的姓名、班级和分数，构建一个Student对象并返回。
    computeAverageScore(List list)方法：遍历链表，累加链表中所有学生人数和总分数，计算出某个班级平均分并返回。
*/
/*请在这里补充StudentList类*/

class StudentList {
    private Scanner sc;

    public List<Student> constructStudentList() {
        sc = new Scanner(System.in);
        List<Student> list = new LinkedList<Student>();
        String n = sc.next();
        Student a = readInStudent();
        while (a != null) {
            if (a.getClassCode().equals(n)) {
                list.add(a);
            }
            a = readInStudent();
        }
        return list;
    }


    public Student readInStudent() {
        sc = new Scanner(System.in);
        String s = sc.next();
        if (s.equals("#")) {
            return null;
        }
        Student student = new Student(s, sc.next(), sc.nextInt());
        return student;
    }

    public double computeAverageScore(List<Student> list) {
        System.out.println(list);
        double ave = 0;
        ListIterator<Student> iterator = list.listIterator(); //important
        while (iterator.hasNext()) {
            ave += iterator.next().getScore();
        }

        return ave / list.size();
    }
}

/*请在这里补充Student类*/
class Student {
    String name;
    String classCode;
    int score;

    public Student() {
        super();
    }

    public Student(String name, String classCode, int score) {
        super();
        this.name = name;
        this.classCode = classCode;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", classCode=" + classCode + ", score=" + score + "]";
    }
}

