package LLD.ElevatorDesign;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
    private static final ElevatorSystem instance = new ElevatorSystem(10, 4, new RRAllocationStrategy());

    ElevatorGroupController egc;
    List<Floor> floors;

    private ElevatorSystem(int floorNum, int elevatorCnt, ElevatorAllocationStrategy eas){
        egc = new ElevatorGroupController(elevatorCnt, eas);
        floors = new ArrayList<>();

        for(int i=0; i<floorNum; i++){
            floors.add(new Floor(i,egc));
        }
    }

    public static ElevatorSystem getInstance(){
        return instance;
    }
}
