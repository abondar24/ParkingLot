package org.abondar.industrial.parkinglot.data;

/**
 *
 * Car data to store
 */
public class CarData {

    private String regNum;

    private CarColor carColor;
    private Integer slotNum;

    public CarData(String regNum, CarColor carColor) {
        this.regNum = regNum;
        this.carColor = carColor;
        this.slotNum=null;
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
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
        return  regNum + " " + carColor;
    }
}
