public class StudentData {
    String group,parental;
    int mathS,readS,writeS;
    StudentData(String g,String p,int m,int r,int w){
        group=g;
        mathS=m;
        readS=r;
        writeS=w;
        parental=p;
    }

    public String getGroup() {
        return group;
    }public int getMathS() {
        return mathS;
    }public String getParental() {
        return parental;
    }public int getReadS() {
        return readS;
    }public int getWriteS() {
        return writeS;
    }

    public float averagemarks(){
        return (mathS+readS+writeS)/3;
    }

    public String toString(){
        return "\t" + group +"\t"+ parental +"\t"+ mathS +"\t"+ readS +"\t"+ writeS;
    }
}
