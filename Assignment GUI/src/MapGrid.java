
import java.awt.GridLayout;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tcw3892
 */
public class MapGrid extends JPanel {

    private int rows, columns;
    private int currentRow, currentColumn;
    private MapGrid[][] mapGrid;

    public MapGrid(int rows, int columns) {

    }

    public void grid() {
        this.setLayout(new GridLayout(rows, columns));
        
        mapGrid = new MapGrid[rows][columns];
        
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                mapGrid[i][j] = new MapGrid(i, j);
                this.add(mapGrid[i][j]);
                if (i == 0 && j == 0) {
                    System.out.println("P");
                }
            }
        }
        currentRow = 0;
        currentColumn = 0;

    }
}
