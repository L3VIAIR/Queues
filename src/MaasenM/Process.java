package MaasenM;

import java.time.Duration;
import java.time.Instant;


public class Process {

	private long id;
    private int priority;
    private int cost;
    private String status;

    // For use by Supervisor.
    public Processor dispatchedTo;
    public Instant dispatchTime;
    public Instant startTime;
    public Instant endTime;
	private String completedurationtext;


    public Process(long id, int priority, int cost) {
        this.id = id;
        this.priority = priority;
        this.cost = cost;
        status = "Virgin";
        }

    public long getId() {
        return id;
    }


    public int getPriority() {
        return priority;
    }

    public int getCost() {
        return cost;
    }
    
    public void setStatus (String status) {
    	if (this.status.equals("Busy")||this.status.equals("In Progress")||this.status.equals("Virigin")){
    		status = this.status;
    	}
    	
    }
    
   public Instant getStarttime(){
	   return startTime;
   }
   
   public void  setStartime(Instant startTime) {
	   startTime = this.startTime;
   }
   
   public Instant getEndtime() {
	   return endTime; 
   }
   
   public void setEndTime (Instant endTime) {
	   endTime = this.endTime; 
   
	   }
   
   public String getcompletedurationtext() {
	   Duration completeDuration = Duration.between(startTime, endTime);
       long durationsec = completeDuration.toMillis()/1000;
       return completedurationtext = "Process " + getId() + " runned for " + durationsec + " seconds";
	 
	   }
   
   }

