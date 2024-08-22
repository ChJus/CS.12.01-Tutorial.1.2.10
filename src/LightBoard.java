import java.util.Random;

public class LightBoard {
  static Random rand = new Random();
  private boolean[][] lights;

  public LightBoard(int numRows, int numCols) {
    lights = new boolean[numRows][numCols];

    // Initialize board with lights being on with 40% chance
    for (int i = 0; i < lights.length; i++) {
      for (int j = 0; j < lights[i].length; j++) {
        lights[i][j] = (LightBoard.rand.nextDouble() >= 0.6);
      }
    }
  }

  public boolean[][] getLights() {
    return lights;
  }

  public void setLights(boolean[][] lights) {
    this.lights = lights;
  }

  public boolean evaluateLight(int row, int col) {
    // Counts number of lights on in the column
    int lightColumnCount = 0;
    for (int i = 0; i < lights.length; i++) {
      if (lights[i][col]) lightColumnCount++;
    }

    if (lights[row][col])               // If the selected cell's light is on,
      return lightColumnCount % 2 != 0; // return true if number of lights on is odd.
    else // Return true if the number of lights on is a multiple of 3 or the selected cell's light is on
      return (lightColumnCount % 3 == 0) || lights[row][col];
  }
}