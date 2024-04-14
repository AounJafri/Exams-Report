import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class LinkedList {
    private Node head;
    private String gender;

    public LinkedList(String gend) throws FileNotFoundException{
        gender = gend;
        adddata(gender);
    }
    public String getGender() {
        return gender;
    }
    public Node getHead() {
        return head;
    }

    public void adddata(String gend) throws FileNotFoundException{
        String file = "src\\exams.csv";

        try (Scanner read = new Scanner(new FileReader(file))){
            read.nextLine();
            read.useDelimiter(",");

            read.next();
            String g = read.next();
            String p = read.next();
            read.next();
            read.next();
            int m = Integer.parseInt(read.next());
            int r = Integer.parseInt(read.next());
            int w = Integer.parseInt(read.next());

            head = new Node(new StudentData(g, p, m, r, w));
            Node temp = head;

            read.nextLine();
            while (read.hasNextLine()) {
                if (read.next().equals(gend)) {
                    String gr = read.next();
                    String pr = read.next();
                    read.next();
                    read.next();
                    int mr = Integer.parseInt(read.next());
                    int rr = Integer.parseInt(read.next());
                    int wr = Integer.parseInt(read.next());

                    temp.next = new Node(new StudentData(gr, pr, mr, rr, wr),temp.next);
                    temp = temp.next;
                }
                read.nextLine();
            }

            if (gender.equals("female")) {
                head=head.next;
            }
        
        }

    }
    
// PROBLEM 3. FINDING MEDIAN IN LINKEDLIST 

    public float median(){
        Node p = head;
        int num=0;
        while (p!=null) {
            num++;
            p=p.next;
        }

        p=head;
        int count=0;
        if(num%2==0) {
            while (p!=null) {
                count++;
                if (count==num/2) {
                    return ((p.data.averagemarks()+p.next.data.averagemarks())/2);
                }
                p=p.next;
            }
            count=0;
            p=head;
        }
        else {
            while (p!=null) {
                count++;
                if (count==((num + 1)/2)) {
                    return p.data.averagemarks();
                }
                p=p.next;
            }
        }
        return 0;
    }

    public void print(){
        Node p = this.head;
        System.out.println("\t\t\t\t\t\tGENDER : " + gender.toUpperCase());
        System.out.println("\tGROUP\tPARENTAL LEVEL\tMath score\tread score\twrite score");
        while (p!=null) {
            System.out.println(p.data);
            p=p.next;
        }
    }

    public int count(){
        Node p = this.head;
        int count=0;
        while(p!=null){
            count++;
            p=p.next;
        }
        return count;
    }

    public static class  Node {
        StudentData data;
        Node next;
        Node(StudentData o){data=o;}

        Node(StudentData o,Node next){
            data=o;
            this.next = next;
        }
        
    }
}
