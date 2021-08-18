package model;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;

public class AllFramewithJPanel extends JFrame implements ActionListener{
	
	 Parameterek parameterek ;
	 WorkingMemory workingMemory;
	 JPanel panel1;
	 JPanel panel2;
	 Button button;
	 Object[] x;
	
	public AllFramewithJPanel(Parameterek parameterek) throws DroolsParserException, IOException{
		
		PackageBuilder packageBuilder = new PackageBuilder();
		String ruleFile = "/com/rule/Rules.drl";
		InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);
		Reader reader = new InputStreamReader(resourceAsStream);
		packageBuilder.addPackageFromDrl(reader);
		org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();
		RuleBase ruleBase = RuleBaseFactory.newRuleBase();
		ruleBase.addPackage(rulesPackage);
		 workingMemory = ruleBase.newStatefulSession();
		 
		 this.parameterek = new Parameterek();
		  panel1= new JPanel();
		  panel2= new JPanel();
		  button = new Button();
		 
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLayout(new FlowLayout());
		 	this.pack();
		 	this.setSize(600,600); 
		 	this.setResizable(true);
		 	this.setVisible(true);
		 	panel1.setBounds(20, 100, 100, 100);
		 	panel1.setBackground(Color.green);
		 	button.addActionListener(this);
		 	this.add(button);
		 	Object[] x = {panel1, panel2};
		 	
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {	
			this.add((Component) x[0]);
		}
		
	}

}
