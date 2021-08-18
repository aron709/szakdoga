package model;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;


import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;



public class ZonaFrame extends JFrame implements ActionListener {
	

	 Parameterek parameterek ;
	 JComboBox<String> comboBox;
	 JButton button;
	 JLabel label;
	 WorkingMemory workingMemory;
	
	 
	 

	
		 public ZonaFrame(Parameterek parameterek) throws DroolsParserException,
			IOException{
			  this.parameterek = parameterek;
			 PackageBuilder packageBuilder = new PackageBuilder();
			
				String ruleFile = "/com/rule/Rules.drl";
				InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);

				Reader reader = new InputStreamReader(resourceAsStream);
				packageBuilder.addPackageFromDrl(reader);
				org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();
				RuleBase ruleBase = RuleBaseFactory.newRuleBase();
				ruleBase.addPackage(rulesPackage);
				 workingMemory = ruleBase.newStatefulSession();
			
			button = new JButton("Tovább");
			label = new JLabel("Adja meg a növény ültetési zónáját: ");
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLayout(new FlowLayout());
		 	this.pack();
		 	this.setSize(400,200); 
		 	this.setResizable(true);
		 	this.setVisible(true);
			button.addActionListener(this);		 														
			this.add(label);
			this.add(button);
					
					
			}

		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==comboBox) {
												
				
			}	
			if(e.getSource()==button) {				
				
				this.dispose();				
					try {
						MergezoFrame newWindow = new MergezoFrame(this.parameterek);
					} catch (DroolsParserException e1) {
						System.out.println("Something went wrong in DroolsParserException");
						e1.printStackTrace();
					} catch (IOException e1) {
						System.out.println("Something went wrong in IOException");
						e1.printStackTrace();
					}
				
			}
		}
	}
