package sample;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.awt.*;

public abstract class Items {
    private SimpleStringProperty name;
    private DoubleProperty price;
    private IntegerProperty xCoord;
    private IntegerProperty yCoord;
    private IntegerProperty lengthSpan;
    private IntegerProperty widthSpan;
    private Color color;



    public Items(String name,
                 Double price,
                 Integer xCoord,
                 Integer yCoord,
                 Integer lengthSpan,
                 Integer widthSpan)
    {this.name = new SimpleStringProperty(name);}

    abstract boolean getType();

    public double getPrice() {
        return price.get();
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public int getxCoord() {
        return xCoord.get();
    }

    public IntegerProperty xCoordProperty() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord.set(xCoord);
    }

    public int getyCoord() {
        return yCoord.get();
    }

    public IntegerProperty yCoordProperty() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord.set(yCoord);
    }

    public int getLengthSpan() {
        return lengthSpan.get();
    }

    public IntegerProperty lengthSpanProperty() {
        return lengthSpan;
    }

    public void setLengthSpan(int lengthSpan) {
        this.lengthSpan.set(lengthSpan);
    }

    public int getWidthSpan() {
        return widthSpan.get();
    }

    public IntegerProperty widthSpanProperty() {
        return widthSpan;
    }

    public void setWidthSpan(int widthSpan) {
        this.widthSpan.set(widthSpan);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }
}

