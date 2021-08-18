package model;


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
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;



public class ViragszinFrame extends JFrame implements ActionListener {
	

	private Parameterek parameterek ;
	private  JComboBox<String> comboBox;
	private  JButton keszButton;
	private  JButton visszButton;
	private  JLabel label;
	/*private JRadioButton rButtonKek;
	private JRadioButton rButtonPiros;
	private JRadioButton rButtonSarga;*/
	private  WorkingMemory workingMemory;
	
	 
	 

	
		 public ViragszinFrame(Parameterek parameterek) throws DroolsParserException,
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
			
			keszButton = new JButton("Kész");
			visszButton = new JButton("Vissza");
			/*rButtonKek = new JRadioButton("Kék");
			rButtonPiros = new JRadioButton("Piros");
			rButtonSarga = new JRadioButton("Sárga");*/
			label = new JLabel("Adja meg a növény virágának színét: ");
			//ButtonGroup group = new ButtonGroup();
			String[] szin = {"Kék", "Piros","Sárga"};
			comboBox =new JComboBox<String>(szin);
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLayout(null);
		 	this.pack();
		 	this.setSize(400,200); 
		 	this.setResizable(true);
		 	this.setVisible(true);
		 	comboBox.addActionListener(this);		
			keszButton.addActionListener(this);
			comboBox.setBounds(120, 50, 120, 20);
			keszButton.setBounds(270, 120, 80, 40);
			label.setBounds(120, 20,400,20);
			visszButton.setBounds(10, 120, 80, 40);
			
			/*group.add(rButtonKek);
			group.add(rButtonPiros);
			group.add(rButtonSarga);
			this.add(rButtonKek);
			this.add(rButtonPiros);
			this.add(rButtonSarga);*/
			this.add(label);
			this.add(comboBox);
			this.add(keszButton);	
			this.add(visszButton);
					
			}

		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==comboBox) {
				parameterek.setVirag_szine(comboBox.getSelectedItem().toString());				
				System.out.println(parameterek.getTalajtipus());						
				
			}	
			if(e.getSource()==visszButton) {
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
			if(e.getSource()==keszButton) {				
				workingMemory.insert(parameterek);
				workingMemory.fireAllRules();
				this.dispose();				
				JOptionPane.showMessageDialog(null,"A keresett növény: "+
				parameterek.getNovenyek()[parameterek.getId()],":)",JOptionPane.PLAIN_MESSAGE);
				
				
				//System.out.println("A keresett növény: "+ parameterek.getNovenyek()[parameterek.getId()]);	
				/*try {
						ExtraSzinFrame newWindow = new ExtraSzinFrame(this.parameterek);
					} catch (DroolsParserException e1) {
						System.out.println("Something went wrong in DroolsParserException");
						e1.printStackTrace();
					} catch (IOException e1) {
						System.out.println("Something went wrong in IOException");
						e1.printStackTrace();
					}*/
				
			}
		}
	}
