package MaasenM;

import java.util.List;

public class Dispatcher {
	private List <Processor> processors;
    private Supervisor supervisor;
    private int processorSpeed = (int) (100+ Math.random()*300);

    public Dispatcher(List<Processor> processors, Supervisor supervisor) {
        this.processors = processors;
        this.supervisor = supervisor;
    }

    // TODO: Take process priority into account.
    public Processor dispatchProcess(Process process) {
        int lowestCost = 0;
        Processor processor = null;
        for (Processor p : processors) {
            int cost = p.getQueueCost();
            if (processor == null || cost < lowestCost) {
                processor = p;
                lowestCost = cost;
            }
        }
        if (processor == null) {
            throw new RuntimeException("No processors.");
        }
        supervisor.recordDispatch(processor, process);
        processor.enqueueProcess(process);
        return processor;
    }

public int getProcessorSpeed() {
	 return processorSpeed;
}




public void recordDispatch() {

	  
}




}