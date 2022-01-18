package application;

public class Assignment {
    private double mark;
    private double weight;

    public Assignment(double mark, double weight){
        this.mark = mark;
        this.weight = weight;
    }

    public double getMark() {
        return this.mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
