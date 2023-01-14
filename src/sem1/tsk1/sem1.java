package sem1.tsk1;

public class sem1 {
    public static void main(String[] args) {
        Triangle t1 = new Triangle(4.0, 2.5, "Full");
        Triangle t2 = new Triangle(5.0, 1.0, "Empty");
        Triangle t3 = new Triangle(5.0, "Empty");
        Triangle t4 = new Triangle();

//        t1.style = "Full";
//        t1.height = 4.0;
//        t1.width = 2.5;
//
//        t2.style = "Same";
//        t2.height = 5.0;
//        t2.width = 1.0;

        System.out.print("Style: ");
        t1.showStyle();
        t1.showInfo();
        System.out.printf("Area = %f \n", t1.area());

        t1.setHeight(3.0);

        System.out.println();

        System.out.print("Style: ");
        t1.showStyle();
        t1.showInfo();
        System.out.printf("Area = %f \n", t1.area());

        System.out.println();

        System.out.print("Style: ");
        t2.showStyle();
        t2.showInfo();
        System.out.printf("Area = %f \n", t2.area());

        System.out.println();

        t2.setStyle("Full");

        System.out.print("Style: ");
        t2.showStyle();
        t2.showInfo();
        System.out.printf("Area = %f \n", t2.area());

        System.out.println();

        System.out.print("Style: ");
        t3.showStyle();
        t3.showInfo();
        System.out.printf("Area = %f \n", t3.area());

        System.out.println();

        System.out.print("Style: ");
        t4.showStyle();
        t4.showInfo();
        System.out.printf("Area = %f \n", t4.area());
    }
}
