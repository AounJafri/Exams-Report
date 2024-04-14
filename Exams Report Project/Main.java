public class Main {
    public static void main(String[] args) throws Exception {

        // TWO LINKEDLISTS MALE AND FEMALE
        LinkedList male = new LinkedList("male");
        LinkedList females = new LinkedList("female");

        // TWO STACKS BASED ON AVG MARKS FOR MALE AND FEMALE STUDENTS
        Stack mstack = new Stack(male);
        Stack fStack = new Stack(females);

        // QUEUE OF PARENTAL LEVELS FROM BOTH STACKS
        // ParentalQueue fQueueclg = new ParentalQueue(fStack, "some college");
        // ParentalQueue mQueueclg = new ParentalQueue(mstack, "some college");

        // QUEUE OF GROUP FROM BOTH STACKS
        GroupQueue maleGroupA = new GroupQueue(mstack, "group A");
        GroupQueue femaleGroupA = new GroupQueue(fStack, "group A");

        GroupQueue maleGroupD = new GroupQueue(mstack, "group D");
        GroupQueue femaleGroupD = new GroupQueue(fStack, "group D");

        // Problem 1: How to find the best average marks of group A and D

        // Solution
        System.out.println("\nBest average marks of group A for male students is : \t" + maleGroupA.first()
                + "\nBest average marks of group A for female students is : \t" + femaleGroupA.first());

        System.out.println("\nBest average marks of group A for male students is : \t" + maleGroupD.first()
                + "\nBest average marks of group A for female students is : \t" + femaleGroupD.first());

        // Problem 2: Which gender has performed better at various parental level of
        // students

        ParentalQueue hsmale = new ParentalQueue(mstack, "high school");
        ParentalQueue clgmale = new ParentalQueue(mstack, "some college");
        // ParentalQueue assmale = new ParentalQueue(mstack, "associate's degree");
        // ParentalQueue bacheolormale = new ParentalQueue(mstack, "bachelor's degree");
        // ParentalQueue mastermale = new ParentalQueue(mstack, "master's degree");

        ParentalQueue hsfemale = new ParentalQueue(fStack, "high school");
        ParentalQueue clgfemale = new ParentalQueue(fStack, "some college");
        // ParentalQueue assfemale = new ParentalQueue(fStack, "associate's degree");
        // ParentalQueue bacheolorfemale = new ParentalQueue(fStack, "bachelor's
        // degree");
        // ParentalQueue masterfemale = new ParentalQueue(fStack, "master's degree");

        if (hsmale.totalaverage() > hsfemale.totalaverage()) {
            System.out.println("Male gender performed better at High school.");
        } else
            System.out.println("Female gender performed better at High school.");

        if (clgmale.totalaverage() > clgfemale.totalaverage()) {
            System.out.println("Male gender performed better at college.");
        } else
            System.out.println("Female gender performed better at college.");

        // SIMILAR FOR DIFFERENT PARENTAL LEVELS

        // Problem 3: Which group has performed better at all parental level levels of
        // students.

        // Soution : To find which group performed better at all parental levels we will
        // find total average of male and female students's groups and print the maximum
        // from them.

        float groupA = mstack.totalGroupAverage("group A") + fStack.totalGroupAverage("group A");
        float groupB = mstack.totalGroupAverage("group B") + fStack.totalGroupAverage("group B");
        float groupC = mstack.totalGroupAverage("group C") + fStack.totalGroupAverage("group C");
        float groupD = mstack.totalGroupAverage("group D") + fStack.totalGroupAverage("group D");
        float groupE = mstack.totalGroupAverage("group E") + fStack.totalGroupAverage("group E");

        float[] arr = { groupA, groupB, groupC, groupD, groupE };

        float max = arr[0];
        int ind = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                ind = i;
            }
        }

        switch (ind) {
            case 0:
                System.out.println("The group which has performed best at all parental levels is : Group A");
                break;
            case 1:
                System.out.println("The group which has performed best at all parental levels is : Group B");
                break;
            case 2:
                System.out.println("The group which has performed best at all parental levels is : Group C");
                break;
            case 3:
                System.out.println("The group which has performed best at all parental levels is : Group D");
                break;
            case 4:
                System.out.println("The group which has performed best at all parental levels is : Group E");
                break;
            default:
                break;
        }

        // Problem 4: What is the median of average marks obtained by male and female
        // students.

        // Median of average marks find by male
        System.out.println(male.median());

        // Median of average marks find by female
        System.out.println(females.median());

    }
}
