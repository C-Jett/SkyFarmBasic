package sample;

public class Item extends Items {
    public Item(String name,
                 Double price,
                 Integer xCoord,
                 Integer yCoord,
                 Integer lengthSpan,
                 Integer widthSpan){
        super(name,price,xCoord,yCoord,lengthSpan,widthSpan);
    }

    @Override
    boolean getType() {
        return false;
    }
}
