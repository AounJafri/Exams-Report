public class GroupQueue {
    NodeQ head = new NodeQ(null);
   private String group,gender;

   public GroupQueue(Stack stack,String group){
       this.group = group;
       gender = stack.gender;
       addData(stack);
   }

   void add(float avg){
       head.prev.next = new NodeQ(new Info(avg),head,head.prev);
       head.prev = head.prev.next;
   }
   void remove(){
       head.next = head.next.next;
       head.next.prev = head;
   } 

   float first(){
       return head.next.avg.getAvg();
   }

   private void addData(Stack stack){

       for(int i=stack.array.length -1; i>=0; i--){

           if (stack.array[i].getGroup().equals(this.group)) {
               this.add(stack.array[i].averagemarks());
           }
       }
   }

   public void print(){
       NodeQ p =this.head.next;
       System.out.println("\n\t\tGroup : " + this.group + "\n");
       while (p!=head){
           System.out.println("Gender : " + this.gender + "\t\tAverage Marks : " + p.avg.getAvg());
           p=p.next;
       }
   }
   
   static class NodeQ{
       Info avg;
       NodeQ next = this;
       NodeQ prev = this;

      private NodeQ(Info data){ avg = data;}
      private  NodeQ(Info d,NodeQ n, NodeQ p){
           avg=d;
           next=n;
           prev=p;
       }
       
   }

   private class  Info {
   float avg;
   Info(float avg){ this.avg = avg;}
   public float getAvg() {
       return avg;
   }
   }
   
   }
