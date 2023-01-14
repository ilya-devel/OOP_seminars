package sem1.tsk1;

class TwoShape {
    protected double height;
    protected double width;

    TwoShape(double h, double w) {
        this.height = h;
        this.width = w;
    }

    TwoShape(double side) {
//        this.height = side;
//        this.width = side;
        this.height = this.width = side;
    }
    TwoShape() {
        this(1.0);
    }


    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void showInfo(){
        System.out.printf("height = %f, width = %f \n", this.height, this.width);
    }
}
