package graphiceditor.Controller;

import graphiceditor.Model.Figur;

import java.util.List;

public class Grafikeditor {

    public static void main(String[] args) {
        new Grafikeditor();

        // Lektion 8
        FigurFileDAO dao = new FigurFileDAO();
        FigurParser fg = new FigurParser(dao);
        List<Figur> figuren = fg.parse();
    }

    private Grafikeditor() {
        @SuppressWarnings("unused")
        EditorFrame frame = new EditorFrame(800, 600);
    }
}
