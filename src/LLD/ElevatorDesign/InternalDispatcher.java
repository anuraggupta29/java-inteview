package LLD.ElevatorDesign;

public class InternalDispatcher {
    ElevatorController ec;
    InternalDispatcher(ElevatorController ec){
        this.ec = ec;
    }

    public void selectFloor(int floor){
        ec.sendInternalRequest(floor);
    }
}
