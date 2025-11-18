package LLD.ElevatorDesign;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ElevatorController {
    ElevatorCar elevator;
    int eid;
    int state = 0;
    int currentFloor = 0;
    PriorityQueue<Integer> upstops = new PriorityQueue<>();
    PriorityQueue<Integer> downstops = new PriorityQueue<>((a,b)->b-a);
    List<Integer> remainingStops = new ArrayList<>();

    ElevatorController(int eid){
        this.eid = eid;
        elevator = new ElevatorCar(eid, this);
    }

    void ProcessElevator(int time){
        while(time>0){
            if(state == 0){
                break;
            }
            else if (state == -1){
                currentFloor -= 1;
                if(!downstops.isEmpty()){
                    if(downstops.peek()==currentFloor){
                        downstops.poll();
                    }
                }
                else{
                    // if upstops => change state and start going up
                    //
                }
            }
        }
    }

    public void sendInternalRequest(int floor) {
        if(floor == currentFloor) return;

        if(state == 1){
            if(floor > currentFloor){
                upstops.offer(floor);
            }
            else{
                remainingStops.add(floor);
            }
        }
        else if(state == -1){
            if(floor < currentFloor){
                downstops.offer(floor);
            }
            else{
                remainingStops.add(floor);
            }
        }
        else{
            if(floor > currentFloor){
                upstops.offer(floor);
                state = 1;
            }
            else{
                downstops.offer(floor);
                state = -1;
            }
        }
    }
}
