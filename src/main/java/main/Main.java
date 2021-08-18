package main;



import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;

import model.TipusFrame;
import model.AllFramewithJPanel;
import model.Parameterek;

public class Main {

	
	public static void main(String[] args) throws DroolsParserException,
			IOException {
		Parameterek parameterek =new Parameterek();
		new TipusFrame(parameterek);
	}
		//Main droolsTest = new Main();
				//droolsTest.executeDrools();
				//new AllFramewithJPanel(parameterek);
		
	

	public void executeDrools() throws DroolsParserException, IOException {

		PackageBuilder packageBuilder = new PackageBuilder();

		String ruleFile = "/com/rule/Rules.drl";
		InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);

		Reader reader = new InputStreamReader(resourceAsStream);
		packageBuilder.addPackageFromDrl(reader);
		org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();
		RuleBase ruleBase = RuleBaseFactory.newRuleBase();
		ruleBase.addPackage(rulesPackage);

		WorkingMemory workingMemory = ruleBase.newStatefulSession();

		Parameterek parameterek = new Parameterek();
		
		
	
		
		/*parameterek.setExpozicio("telt naps�t�s");
		parameterek.setExtra_szin("-");
		parameterek.setMax_magassag(30);
		parameterek.setMax_szelesseg(75);
		parameterek.setMax_ultetesi_zona(10);
		parameterek.setMax_viragzas("J�nius");
		parameterek.setMin_magassag(15);
		parameterek.setMin_szelesseg(30);
		parameterek.setMin_ultetesi_zona(3);
		parameterek.setMin_viragzas("M�jus");
		parameterek.setPH("-");
		parameterek.setTalajtipus("K�zepesen nedves");
		parameterek.setTipus("L�gysz�r� �vel�");
		parameterek.setToxicias("-");
		parameterek.setVirag_szine("k�k");
		parameterek.setExtra_szin("-");*/
		
		
		/*parameterek.setExpozicio("telt naps�t�s");
		parameterek.setExtra_szin("-");
		parameterek.setMax_magassag(150);
		parameterek.setMax_szelesseg(60);
		parameterek.setMax_ultetesi_zona(10);
		parameterek.setMax_viragzas("J�lius");
		parameterek.setMin_magassag(60);
		parameterek.setMin_szelesseg(30);
		parameterek.setMin_ultetesi_zona(4);
		parameterek.setMin_viragzas("J�nius");
		parameterek.setPH("-");
		parameterek.setTalajtipus("agyagos");
		parameterek.setTipus("k�t�ves");
		parameterek.setToxicias("-");
		parameterek.setVirag_szine("piros");
		parameterek.setExtra_szin("-");*/
	String[] novenyek = {"HIBA","Ind�s f�", "Piros gy�sz�vir�g"};
		
		
		
		



		
		workingMemory.insert(parameterek);
		workingMemory.fireAllRules();
		
		
		System.out.println("Az id:"+ parameterek.getId());
		
		System.out.println("A keresett n�v�ny: "+ parameterek.getNovenyek()[parameterek.getId()]);
		
	
	}

}