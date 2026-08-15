package csc213.finalexam_4_2311249;

import java.io.Serializable;

public class TollPlazaVehicleTag  implements Serializable {
    private String tagId, vehicleRegNo, vehicleType;
    private float balance, tagMaintenanceFee;
    private boolean utilityVehicle, govtVehicle;

    public TollPlazaVehicleTag(String tagId, String vehicleRegNo, String vehicleType, float balance, boolean isUtilityVehicle, boolean isGovtVehicle) {
        this.tagId = tagId;
        this.vehicleRegNo = vehicleRegNo;
        this.vehicleType = vehicleType;
        this.balance = balance;
        this.utilityVehicle = isUtilityVehicle;
        this.govtVehicle = isGovtVehicle;
        this.tagMaintenanceFee = getTagMaintenanceFee();
    }

    public TollPlazaVehicleTag() {
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getVehicleRegNo() {
        return vehicleRegNo;
    }

    public void setVehicleRegNo(String vehicleRegNo) {
        this.vehicleRegNo = vehicleRegNo;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float getTagMaintenanceFee() {
        float fee = 0;
        if (vehicleType.equals("Car")){
            fee = 200;
        } else if (vehicleType.equals("SUV") || vehicleType.equals("MPV")) {
            fee = 300; 
        } else if (vehicleType.equals("Bus") || vehicleType.equals("Truck")) {
            fee = 500;
        }

        if (utilityVehicle){
           fee = 0;
        } else if (govtVehicle) {
            fee = (float) (fee * 0.5);
        }

        return fee;
    }

    public void setTagMaintenanceFee(float tagMaintenanceFee) {
        this.tagMaintenanceFee = tagMaintenanceFee;
    }

    public boolean isUtilityVehicle() {
        return utilityVehicle;
    }

    public void setUtilityVehicle(boolean utilityVehicle) {
        this.utilityVehicle = utilityVehicle;
    }

    public boolean isGovtVehicle() {
        return govtVehicle;
    }

    public void setGovtVehicle(boolean govtVehicle) {
        this.govtVehicle = govtVehicle;
    }

    @Override
    public String toString() {
        return "TollPlazaVehicleTag{" +
                "tagId='" + tagId + '\'' +
                ", vehicleRegNo='" + vehicleRegNo + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", balance=" + balance +
                ", tagMaintenanceFee=" + tagMaintenanceFee +
                ", utilityVehicle=" + utilityVehicle +
                ", govtVehicle=" + govtVehicle +
                '}';
    }
}
