package sem1.tsk1;

class Triangle extends TwoShape {
    private String style;

    Triangle(double h, double w, String style) {
//        this.height = h;
//        this.width = w;
        super(h,w);
//        this.style = style;
        setStyle(style);
    }

    Triangle(double side, String style) {
        super(side);
        setStyle(style);
    }
    Triangle() {
        super();
        setStyle("");
    }

    public void setStyle(String style) {
        this.style = style;
    }

    double area() {
        return (this.height * this.width) / 2;
    }

    void showStyle() {
        System.out.printf("Triangle %s \n", this.style);
    }
}
