package LLD.ElevatorDesign;

public interface ElevatorAllocationStrategy {

    ElevatorController allocateElevator(ElevatorGroupController egc, int floor, int direction);
}
