package com.daniel.table;

/**
 * Table class to store its width and height
 */
public class Table {
    /**
     * table widht
     */
    private int width;
    /**
     * table height
     */
    private int height;

    /**
     * Table constructor to initialize it with its height and height
     * @param width table width
     * @param height table height
     */
    public Table(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * getter for table width
     * @return table width
     */
    public int getWidth() {
        return width;
    }

    /**
     * setter for table width
      * @param width table width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * getter for table height
     * @return table height
     */
    public int getHeight() {
        return height;
    }

    /**
     * setter for table height
     * @param height table height
     */
    public void setHeight(int height) {
        this.height = height;
    }
}
