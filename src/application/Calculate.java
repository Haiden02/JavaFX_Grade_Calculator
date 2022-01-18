package application;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Calculate {
    private final List<Double> marks;
    private final List<Double> weights;
    private double overall;

    public Calculate(String fileName) throws FileNotFoundException {
        try{
            FileEditor editor = new FileEditor();
            editor.read(fileName);
            this.marks = new ArrayList<>(editor.getMarks());
            this.weights = new ArrayList<>(editor.getWeights());
            this.overall = 0;
        }catch (FileNotFoundException e){
            throw new FileNotFoundException("File Not Found");
        }
    }

    public void calculateMark() {
        double mark = 0;
        double weight = 0;

        for(int i = 0; i < this.marks.size(); i++){
            mark += this.marks.get(i) * this.weights.get(i);
            weight += this.weights.get(i);
        }
        this.overall = mark/weight;
    }

    @Override
    public String toString(){
        calculateMark();
        return String.format("%.4g", this.overall) + "%";
    }
}
