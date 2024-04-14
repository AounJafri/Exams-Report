public class Stack {
    int size;
    StudentData[] array;
    String gender;


    public Stack(LinkedList list){
        array = new StudentData[list.count()];
        gender = list.getGender();
        addData(list);
    }


    public void push(StudentData obj){
        array[size++] = obj;
    }
    public StudentData pop(){
        StudentData temp = array[--size];
        array[size] = null;
        return temp;
    }
    public int size(){return size;}

    public boolean isEmpty(){return (size()==0);}

    public StudentData peek(){ return array[size-1];}


    public void addData(LinkedList list){
        LinkedList.Node p = list.getHead();
        while (p!=null) {
            this.push(p.data);
            p=p.next;
        }

        for(int i=0; i<size() -1; i++){
            for(int j=0; j<size()-i-1; j++){

                if (array[j].averagemarks() > array[j+1].averagemarks()) {
                    StudentData temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    public void print(){
        System.out.println("this stack is for : ");
        for(int i=size()-1; i>=0; i--){
            System.out.println(array[i]);
        }
    }

    public float totalGroupAverage(String group){
        float sum=0;
        for(int i=size()-1; i>=0; i--){
            if (array[i].getGroup().equals(group)) {
                sum += array[i].averagemarks();
            }
        }
        return sum/size();
    }
    
}
