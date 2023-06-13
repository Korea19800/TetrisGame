package com.bamlakKangjinQuan; 

import java.util.Random;

public class Shape {

  // various shapes of tetris block
  protected enum Tetrominoe {
    NoShape, ZShape, SShape, LineShape,
    TShape, SquareShape, LShape, MirroredLShape
  }

  private Tetrominoe pieceShape;
  private int coords[][];
  private int[][][] coordsTable;
  private int rightBound, bottomBound;

  // ********************************************************************************************************************//
  public Shape() {

    initShape();
  }

  // ********************************************************************************************************************//
  // answer code is inside this method
  private void initShape() {

    coords = new int[4][2];

    coordsTable = new int[][][] {
        { { 1, -1 }, { 0, -1 }, { 0, 0 }, { 0, 1 } }, // right side L block
        { { 0, -1 }, { 0, 0 }, { -1, 0 }, { -1, 1 } }, // left up skew block
        { { 0, -1 }, { 0, 0 }, { 1, 0 }, { 1, 1 } }, // right up skew block
        { { 0, -1 }, { 0, 0 }, { 0, 1 }, { 0, 2 } }, // straight line block
        { { -1, 0 }, { 0, 0 }, { 1, 0 }, { 0, 1 } }, // T block
        { { 0, 0 }, { 1, 0 }, { 0, 1 }, { 1, 1 } }, // square block
        { { -1, -1 }, { 0, -1 }, { 0, 0 }, { 0, 1 } }, // left side L block

        { { 0, 0 }, { 1, 0 }, { 0, 1 }, { 0, 0 } }// New code for V shape block<-- Answer!
    };

    setShape(Tetrominoe.NoShape);
  }

  // ********************************************************************************************************************//
  protected void setShape(Tetrominoe shape) {

    for (int i = 0; i < 4; i++) {

      for (int j = 0; j < 2; ++j) {

        coords[i][j] = coordsTable[shape.ordinal()][i][j];
      }
    }

    pieceShape = shape;
  }

  // ********************************************************************************************************************//
  private void setX(int index, int x) {
    coords[index][0] = x;
  }

  private void setY(int index, int y) {
    coords[index][1] = y;
  }

  public int x(int index) {
    return coords[index][0];
  }

  public int y(int index) {
    return coords[index][1];
  }

  public Tetrominoe getShape() {
    return pieceShape;
  }

  // ********************************************************************************************************************//
  public void setRandomShape() {

    var r = new Random();
    int x = Math.abs(r.nextInt()) % 7 + 1;

    Tetrominoe[] values = Tetrominoe.values();
    setShape(values[x]);
  }

  // ********************************************************************************************************************//
  public int minX() {

    int m = coords[0][0];

    for (int i = 0; i < 4; i++) {

      m = Math.min(m, coords[i][0]);
    }

    return m;
  }

  // ********************************************************************************************************************//
  public int minY() {

    int m = coords[0][1];

    for (int i = 0; i < 4; i++) {

      m = Math.min(m, coords[i][1]);
    }

    return m;
  }

  // ********************************************************************************************************************//
  public void setBounds(int width, int height) {
    rightBound = width;
    bottomBound = height;
  }

  // ********************************************************************************************************************//
  public Shape rotateLeft() {

    if (pieceShape == Tetrominoe.SquareShape) {

      return this;
    }

    var result = new Shape();
    result.pieceShape = pieceShape;

    for (int i = 0; i < 4; ++i) {

      result.setX(i, y(i));
      result.setY(i, -x(i));
    }

    return result;
  }

  // ********************************************************************************************************************//
  public Shape rotateRight() {

    if (pieceShape == Tetrominoe.SquareShape) {

      return this;
    }

    var result = new Shape();
    result.pieceShape = pieceShape;

    for (int i = 0; i < 4; ++i) {

      result.setX(i, -y(i));
      result.setY(i, x(i));
    }
    return result;
  }
  // ********************************************************************************************************************//
}
