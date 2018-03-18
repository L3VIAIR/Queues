package MaasenM;



import java.time.Duration;
import java.time.Instant;




public class Supervisor {
	
    private String completedurationtext;

	public void recordDispatch(Processor processor, Process process) {
        process.dispatchedTo = processor;
        process.dispatchTime = Instant.now();
        System.out.println("Process " + process.getId() + " dispatched to processor " + processor.getId() + ".");
        System.out.println();
    }

    public void recordProcessStart(Processor processor, Process process) {
        process.startTime = Instant.now();
        long id = process.getId();
        Duration waitDuration = Duration.between(process.dispatchTime, process.startTime);
        System.out.println("Process " + id + " waited " + waitDuration.toMillis() + " milliseconds to start.");
        System.out.println("Priority was " + process.getPriority() + ".");
        System.out.println();
    }

    public void recordProcessEnd(Processor processor, Process process) {
        process.endTime = Instant.now();
        System.out.println("Processor " + processor.getId() + " has " + processor.getQueueLength() + " processes left in queue.");
	
    }
    

   public String getcompletedurationtext() {
	   return completedurationtext;
   }
   


	
}
