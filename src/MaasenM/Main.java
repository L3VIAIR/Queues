package MaasenM;


	import java.util.ArrayList;
	import java.util.List;
	import java.awt.EventQueue;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import javax.swing.*;

	public class Main extends javax.swing.JFrame {

	    //Globals 
		int anzProcessor = 1;
	    boolean processrunning = true;
	    Processor processor;
	    final JLabel Welcome = new JLabel();
	    JButton abbruch;
	    final JLabel copyright = new JLabel();
	    JRadioButton core1;
	    ButtonGroup coreGroup;
	    JRadioButton cores2;
	    JRadioButton cores4;
	    JDialog jDialog1;
	 	JLabel jLabel1;
	 	JTextField resultfield;
	    JButton startbutton;
	    
		    private static List<Processor> processors;
		    private static Dispatcher dispatcher;
		    private static Supervisor supervisor;


	    
	    //Contructor, which inits components 
	    public Main() {
	        initComponents();
	    }

	                         
	    private void initComponents() {
	          
	    
	    	//components 
	        
	        jDialog1 = new JDialog();
	        coreGroup = new ButtonGroup();
	        resultfield = new JTextField();
	        startbutton = new JButton();
	        abbruch = new JButton();
	        jLabel1 = new JLabel();
	        cores2 = new JRadioButton();
	        cores4 = new JRadioButton();
	        core1 = new JRadioButton();
	        
	      
	        //components ordered in Layout 
	        GroupLayout jDialog1Layout = new GroupLayout(jDialog1.getContentPane());
	        jDialog1.getContentPane().setLayout(jDialog1Layout);
	        jDialog1Layout.setHorizontalGroup(
	            jDialog1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGap(0, 400, Short.MAX_VALUE)
	        );
	        jDialog1Layout.setVerticalGroup(
	            jDialog1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGap(0, 300, Short.MAX_VALUE)
	        );

	        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	        resultfield.setText("This field and the Stop-Button don't work in this build");

	        startbutton.setText("Start");
	        startbutton.addActionListener(new ActionListener() {
	        	
	        	//actual code begins if action of startbutton is performed 
	        	public void actionPerformed(ActionEvent evt) {
	                try {
						startbuttonActionPerformed(evt);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	        });

	        abbruch.setText("Abbruch");
	        abbruch.addActionListener(new ActionListener() {
	        	@Override
	            public void actionPerformed(ActionEvent evt) {
	                abbruchActionPerformed(evt);
	            }
	        });

	        jLabel1.setText("Processors");

	        coreGroup.add(cores2);
	        cores2.setText("2 Cores");
	        cores2.setToolTipText("Create 2 CPU Cores");
	        cores2.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                cores2ActionPerformed(evt);
	            }
	        });

	        coreGroup.add(cores4);
	        cores4.setText("4 Cores");
	        core1.setToolTipText("Create 4 CPU Cores");
	        cores4.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                cores4ActionPerformed(evt);
	            }
	        });
	        
	        coreGroup.add(core1);
	        core1.setText("1 Cores");
	        core1.setToolTipText("Create 1 CPU Core");
	        core1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                core1ActionPerformed(evt);
	            }
	        });

	        //Constant Text 
	        copyright.setText("(c) Michelle Maasen");
	        copyright.setRequestFocusEnabled(false);
	        Welcome.setText("Welcome to Queue-Simulation ");


	        //Layoutorder 
	  
	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	       
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(26, 26, 26)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(Welcome, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)
	                        .addGap(0, 0, Short.MAX_VALUE))
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(resultfield, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE)
	                        .addGap(18, 18, 18)
	                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                            .addComponent(startbutton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(abbruch, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addGroup(layout.createSequentialGroup()
	                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                                    .addComponent(jLabel1)
	                                    .addComponent(cores4)
	                                    .addComponent(copyright)
	                                    .addComponent(cores2)
	                                    .addComponent(core1))
	                                .addGap(0, 80, Short.MAX_VALUE)))))
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(Welcome,GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
	                .addGap(10, 10, 10)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addComponent(resultfield, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(startbutton, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(abbruch, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(jLabel1)
	                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(core1)
	                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addComponent(cores2)
	                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(cores4)
	                        .addGap(18, 18, 18)
	                        .addComponent(copyright)))
	                .addContainerGap())
	        );

	        pack();
	    }
	    
	   
	    
	    
	    private void startbuttonActionPerformed(ActionEvent evt) throws InterruptedException {                                            
	    	//the real Process starts TODO implement a real stop button. TODO Concentrate on the real thing!!!!
	    		
	   
	  	    	if (processrunning == true) {
	  	    	EventQueue.invokeLater(new Runnable() {
	  	               
	  	    		public void run() {
	  	           	        supervisor = new Supervisor();

	  	           	        
	  	           	        processors = new ArrayList<>();
	  	           	        for (int i = 1; i <= anzProcessor; ++i) {
	  	           	            Processor processor = new Processor(i, 500, supervisor);
	  	           	            processor.startExecution();
	  	           	            processors.add(processor);
	  	           	        }

	  	           	        dispatcher = new Dispatcher(processors, supervisor);

	  	           	        long processId = 0;
	  	     
	  	           	        while (true) {
	  	           	            int priority = (int) (Math.random() * 100);
	  	           	            int cost = (int) (Math.random() * 100);
	  	           	            Process process = new Process(processId, priority, cost);
	  	           	            dispatcher.dispatchProcess(process);
	  	           	            //resultfield.setText(process.getcompletedurationtext());
	  	           	            try {
	  	           	                Thread.sleep(500/anzProcessor);
	  	           	            } catch (InterruptedException exception) {
	  	           	            }
	  	           	            processId += 1;
	  	           	            
	  	           	        }
	  	           	    }            
	  	    		
	  	           });}
	    	  }  
					                                     

	 
	    private void abbruchActionPerformed(ActionEvent evt) {  
	    	processrunning = false;
	    
	    }                                      

	    
	    private void cores2ActionPerformed(ActionEvent evt) {                                       
	       anzProcessor = 2;
	      
	       }
	                                            

	    private void core1ActionPerformed(ActionEvent evt) {                                      
	      anzProcessor = 1;
	       
	    }                                     

	    private void cores4ActionPerformed(ActionEvent evt) {                                       
	      anzProcessor =4; 
	    }
	                                         
	   

	 

	   public static void main(String args[]) {
	    	
	    	EventQueue.invokeLater(new Runnable() {
	               public void run() {
	                   new Main().setVisible(true);
	                  
	                   
	               }
	           });
	    }
	}





	    


