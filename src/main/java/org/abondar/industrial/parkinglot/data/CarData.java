package org.abondar.industrial.parkinglot.data;

/**
 *
 * Car data to store
 */
public class CarData {

    private String plateNum;

    private CarColor carColor;
    private Integer slotNum;

    public CarData(String plateNum, CarColor carColor) {
        this.plateNum = plateNum;
        this.carColor = carColor;
        this.slotNum=null;
    }

    public String getPlateNum() {
        return plateNum;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }

    public CarColor getCarColor() {
        return carColor;
    }

    public void setCarColor(CarColor carColor) {
        this.carColor = carColor;
    }

    public Integer getSlotNum() {
        return slotNum;
    }

    public void setSlotNum(Integer slotNum) {
        this.slotNum = slotNum;
    }

    @Override
    public String toString() {
        return  plateNum + " " + carColor;
    }
}
