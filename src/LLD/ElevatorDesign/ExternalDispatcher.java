package LLD.ElevatorDesign;

public class ExternalDispatcher {
    int floorNo;
    ElevatorGroupController egc;

    ExternalDispatcher(int floorNo, ElevatorGroupController egc){
        this.floorNo = floorNo;
        this.egc = egc;
    }

    public void sendExternalRequest(int direction){
        egc.sendExternalRequest(floorNo, direction);
    }
}
