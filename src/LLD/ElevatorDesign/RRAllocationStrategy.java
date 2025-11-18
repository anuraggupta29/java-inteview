package LLD.ElevatorDesign;

public class RRAllocationStrategy implements ElevatorAllocationStrategy{
    int eno = 0;

    @Override
    public ElevatorController allocateElevator(ElevatorGroupController egc, int floor, int direction) {
        ElevatorController ret = egc.ec.get(eno);
        if(eno == egc.ec.size()-1) eno = 0;
        return ret;
    }
}
