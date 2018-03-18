package MaasenM;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Processor {


    private long id;
    private String status;
    private int speed;
    private Supervisor supervisor;
    private Thread executionThread;
    private BlockingQueue<Process> processQueue;
    private Process currentProcess;
    private int queueLength;
    private int queueCost;

    public Processor(int id, long speed, Supervisor supervisor2) {
        this.id = id;
        this.setSpeed((int) speed);
        this.supervisor = supervisor2;

        status = "Idle";
        executionThread = new Thread(this::executionLoop);
        processQueue = new LinkedBlockingQueue<>();
    }

    public long getId() {
        return id;
    }

    public int getQueueLength() {
        return queueLength;
    }

    public int getQueueCost() {
        return queueCost;
    }

    public void enqueueProcess(Process process) {
        try {
            processQueue.put(process);
            queueLength += 1;
            queueCost += process.getCost();
        } catch (InterruptedException exception) {
            throw new RuntimeException("Interrupt while trying to enqueue process.");
        }
    }

    public Process getCurrentProcess() {
        return currentProcess;
    }

    public void startExecution() {
        executionThread.start();
    }

    private void executionLoop() {
    	//TODO include priority and Processorspeed
    	
        while (true) {
            try {
                Process process = processQueue.take();
                queueCost -= process.getCost();
                int processcost = process.getCost();
                queueLength -= 1;
                status = "Busy";
                process.setStatus("Started");
                supervisor.recordProcessStart(this, process);
                currentProcess = process;
                executeProcess(process);
                status = "Idle";
                process.setStatus("Finished");
                currentProcess = null;
                
            } catch (InterruptedException exception) {
                throw new RuntimeException("Processor was interrupted.");
            }
        }
    }

    private void executeProcess(Process process) throws InterruptedException {
        Thread.sleep(process.getCost() * 10);
    }
    
    private void setStatus(String status) {
    	if (this.status.equals("Busy")||this.status.equals("Idle")) {
    		status = this.status;
    	}
    }

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

}