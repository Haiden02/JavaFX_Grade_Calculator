package application;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileEditor {
    private final List<Double> marks;
    private final List<Double> weights;

    public FileEditor(){
        this.marks = new ArrayList<>();
        this.weights = new ArrayList<>();
    }

    public void read(String fileName) throws FileNotFoundException{
        this.marks.clear();
        this.weights.clear();

        try {
            File file = new File("src/res/"+ fileName.toUpperCase() +".txt");
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String[] data = reader.nextLine().split(" ");
                this.marks.add(Double.parseDouble(data[0]));
                this.weights.add(Double.parseDouble(data[1]));
            }

            reader.close();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File Not Found");
        }
    }

    public void edit(String fileName, List<Double> marks, List<Double> weights) throws FileNotFoundException {
        this.marks.clear();
        this.weights.clear();
        String filePath = "src/res/"+ fileName.toUpperCase() +".txt";
        File oldF = new File(filePath);
        File newF = new File("src/res/temp.txt");

        try{
            FileWriter f = new FileWriter(newF, true);
            BufferedWriter b = new BufferedWriter(f);
            PrintWriter p = new PrintWriter(b);

            for(int i = 0; i < marks.size(); i++){
                this.marks.add(marks.get(i));
                this.weights.add(weights.get(i));
                p.println(marks.get(i) + " " + weights.get(i));
            }

            p.flush();
            p.close();

            if(!oldF.delete()){
                throw new Exception("File Not Deleted");
            }

            File edited = new File(filePath);

            if(!newF.renameTo(edited)){
                throw new Exception("File Not Renamed");
            }
        } catch(Exception e){
            throw new FileNotFoundException("File Not Found");
        }
    }

    public List<Double> getMarks() {
        return new ArrayList<>(this.marks);
    }

    public List<Double> getWeights() {
        return new ArrayList<>(this.weights);
    }
}
