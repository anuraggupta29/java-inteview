package LLD.ElevatorDesign;

public class Floor {
    int floorNo;
    ExternalDispatcher ed;

    Floor(int floorNo, ElevatorGroupController egc){
        this.floorNo = floorNo;
        ed = new ExternalDispatcher(floorNo, egc);
    }
}
