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
import javax.swing.JRadioButton;

import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;

import main.Main;

public class TalajTipusFrame extends JFrame implements ActionListener{


	private Parameterek parameterek ;
	private JComboBox<String> comboBox;
	private JButton buttonTovabb;
	private JButton buttonVissza;
	private WorkingMemory workingMemory;
	private JLabel label;
	
	
	public TalajTipusFrame(Parameterek parameterek) throws DroolsParserException, IOException {
		
		 PackageBuilder packageBuilder = new PackageBuilder();
		 	this.parameterek = parameterek;
			String ruleFile = "/com/rule/Rules.drl";
			InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);
			Reader reader = new InputStreamReader(resourceAsStream);
			packageBuilder.addPackageFromDrl(reader);
			org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();
			RuleBase ruleBase = RuleBaseFactory.newRuleBase();
			ruleBase.addPackage(rulesPackage);
			 workingMemory = ruleBase.newStatefulSession();
			 
				
		
		
		String[] talajTipus = { "agyagos","Közepesen nedves"};
		buttonTovabb = new JButton("tovább");
		buttonVissza = new JButton("Vissza");
		comboBox =new JComboBox<String>(talajTipus);
		label = new JLabel("Adja meg a talajtípust: ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 	this.setLayout(null);
	 	this.pack();
	 	this.setSize(400,200); 
	 	this.setResizable(true);
		this.setVisible(true);
		comboBox.setBounds(120, 50, 120, 20);
		buttonTovabb.setBounds(270, 120, 80, 40);
		label.setBounds(120, 20,400,20);
		buttonVissza.setBounds(10, 120, 80, 40);
		
		comboBox.addActionListener(this);		
		buttonTovabb.addActionListener(this);
		buttonVissza.addActionListener(this);
		this.add(label);
		this.add(comboBox);
		this.add(buttonTovabb);
		this.add(buttonVissza);
		
		
		
	
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==comboBox) {
			
			parameterek.setTalajtipus(comboBox.getSelectedItem().toString());
			workingMemory.insert(parameterek);
			workingMemory.fireAllRules();
			System.out.println(parameterek.getTalajtipus());
			System.out.println("Az id: "+ parameterek.getId());
		}
		if(e.getSource()==buttonVissza) {
			this.dispose();	
			try {
				TipusFrame newWindow = new TipusFrame(this.parameterek);
			} catch (DroolsParserException e1) {
				System.out.println("Something went wrong in DroolsParserException");
				e1.printStackTrace();
			} catch (IOException e1) {
				System.out.println("Something went wrong in IOException");
				e1.printStackTrace();
			}
		}
		if(e.getSource()==buttonTovabb) {
			workingMemory.insert(parameterek);
			//workingMemory.fireAllRules();
			
			//System.out.println("A keresett növény: "+ parameterek.getNovenyek()[parameterek.getId()]);
			this.dispose();	
			/*try {
				MagassagFrame newWindow = new MagassagFrame(this.parameterek);
			} catch (DroolsParserException e1) {
				System.out.println("Something went wrong in DroolsParserException");
				e1.printStackTrace();
			} catch (IOException e1) {
				System.out.println("Something went wrong in IOException");
				e1.printStackTrace();
			}*/
			try {
				ViragszinFrame newWindow = new ViragszinFrame(this.parameterek);
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
