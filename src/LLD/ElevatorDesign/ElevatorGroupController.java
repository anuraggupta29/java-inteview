package LLD.ElevatorDesign;

import java.util.ArrayList;
import java.util.List;

public class ElevatorGroupController {
    List<ElevatorController> ec;
    ElevatorAllocationStrategy eas;

    ElevatorGroupController(int elevatorCnt, ElevatorAllocationStrategy eas){
        ec = new ArrayList<>();
        for(int i=0; i<elevatorCnt; i++) ec.add(new ElevatorController(i));
        this.eas = eas;
    }

    public void sendExternalRequest(int floorNo, int direction) {
        ElevatorController ec = eas.allocateElevator(this, floorNo, direction);
        ec.sendInternalRequest(floorNo);
    }
}
