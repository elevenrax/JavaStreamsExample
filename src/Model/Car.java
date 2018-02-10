package Model;

public class Car {

    public enum Cylinder { FOUR, SIX, EIGHT, TEN, TWELVE }

    private String mMake;
    private String mModel;
    private Cylinder mCylinder;
    private int mPrice;
    private boolean mIsNewCar;

    // Deliberately left out `mIsNewCar` to demonstrate stream
    public Car(String make, String model, Cylinder cylinder, int price) {
        mMake = make;
        mModel = model;
        mCylinder = cylinder;
        mPrice = price;

    }

    public String getMake() {
        return mMake;
    }

    public void setMake(String mMake) {
        this.mMake = mMake;
    }

    public String getModel() {
        return mModel;
    }

    public void setModel(String mModel) {
        this.mModel = mModel;
    }

    public Cylinder getCylinder() {
        return mCylinder;
    }

    public void setCylinder(Cylinder mCylinder) {
        this.mCylinder = mCylinder;
    }

    public int getPrice() {
        return mPrice;
    }

    public void setPrice(int mPrice) {
        this.mPrice = mPrice;
    }

    public boolean isNewCar() {
        return mIsNewCar;
    }

    public void setNewCar(boolean newCar) {
        mIsNewCar = newCar;
    }

    @Override
    public String toString() {
        return "{make: " + mMake + ",  model: " + mModel + ",  cylinders: " + mCylinder + "}";
    }
}
