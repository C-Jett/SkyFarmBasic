package sample;

public class ItemContainer extends Items {
    public ItemContainer(String name,
                         Double price,
                         Integer xCoord,
                         Integer yCoord,
                         Integer lengthSpan,
                         Integer widthSpan){
        super(name,price,xCoord,yCoord,lengthSpan,widthSpan);
    }

    @Override
    boolean getType() {
        return true;
    }
}
