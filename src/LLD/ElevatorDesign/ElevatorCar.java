package LLD.ElevatorDesign;

public class ElevatorCar {
    int eid;
    InternalDispatcher id;

    ElevatorCar(int eid, ElevatorController ec){
        this.eid = eid;
        id = new InternalDispatcher(ec);
    }
}
