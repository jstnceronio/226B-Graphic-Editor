package test.Controller;

import graphiceditor.Controller.FigurDAO;

public class FigurDAOStub implements FigurDAO {

    private String[] testFiguren = {
            "Rechteck 40 20 80 30",
            "Kreis 60 50 40",
            "Linie 30 70 70 80"
    };
    private int currentFigur = 0;

    @Override
    public String[] readNextFigurData() {
        if (currentFigur < testFiguren.length) {
            String[] figurData = testFiguren[currentFigur].split("\\s");
            currentFigur++;
            return  figurData;
        }
        return null;
    }
}
