package model;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;

import main.Main;

public class TipusFrame extends JFrame implements ActionListener {
	

	 private Parameterek parameterek ;
	 private JComboBox<String> comboBox;
	 private JButton buttonTovabb;
	 private JLabel label;
	 private  WorkingMemory workingMemory;
	
	 
	 

	
		 public TipusFrame(Parameterek parameterek) throws DroolsParserException,
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
				
			 
			 
			 
				
			
			String[] tipus = {"Lágyszárú évelö","kétéves"};
			
			buttonTovabb = new JButton("Tovább");
			comboBox =new JComboBox<String>(tipus);
			label = new JLabel("Adja meg a növény tipusát: ");
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLayout(null);
		 	this.pack();
		 	this.setSize(400,200); 
		 	this.setResizable(true);
		 	this.setVisible(true);
			
		 	
			
			comboBox.addActionListener(this);		
			buttonTovabb.addActionListener(this);
			comboBox.setBounds(120, 50, 120, 20);			
			buttonTovabb.setBounds(270, 120, 80, 40);
			label.setBounds(120, 20,400,20);
			
			
			this.add(label);
			this.add(comboBox);
			this.add(buttonTovabb);
		
			
		
			
		}

		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==comboBox) {
				
				parameterek.setTipus(comboBox.getSelectedItem().toString());
				workingMemory.insert(parameterek);
				//workingMemory.fireAllRules();
				System.out.println(parameterek.getTipus());
			
				System.out.println("Az id: "+ parameterek.getId());
				
				
			}	
			if(e.getSource()==buttonTovabb) {				
				System.out.println("Választott tipus: "+parameterek.getTipus());
				this.dispose();				
					try {
						TalajTipusFrame newWindow = new TalajTipusFrame(this.parameterek);
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
