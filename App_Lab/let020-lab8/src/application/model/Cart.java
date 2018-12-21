package application.model;

import java.util.HashMap;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;

import application.Main;
import application.controller.CartController;
import javafx.collections.ObservableList;

public class Cart{
	//private int quantity;

	private  HashMap<Item, Integer> map = new HashMap<Item,Integer>();
	public Cart() {
		map.put(new Item("Apple" 		, 0.89), 0);
		map.put(new Item("Banana"		, 0.27), 0);
		map.put(new Item("Carrot"		, 0.89), 0);
		map.put(new Item("Dog Food"		, 7.29), 0);
		map.put(new Item("Eggplant"		, 2.69), 0);
		map.put(new Item("Fennel"		, 1.49), 0);
		map.put(new Item("Grapes"		, 3.99), 0);
		map.put(new Item("Horseraddish"	, 0.59), 0);
		map.put(new Item("Ice"			, 0.50), 0);
		map.put(new Item("Juice"		, 2.39), 0);
		map.put(new Item("Kale"			, 1.23), 0);
		map.put(new Item("Lemon"		, 0.16), 0);
	}
	
	
	public void addItem(String itemName) {
		String s[] = itemName.split(":");
		
		System.out.println(s[0]);
	
		for(Item i : map.keySet()){		
			if(s[0].equals(i.getIName())){
				map.put(i, map.get(i) + 1);		
				System.out.println("quantity: "+map.get(i));
				//i.setiQuantity(map.get(i));
				break;
			}
		}
	}

	public double totalForItem(Item i, int quantity){
		return (i.getIPrice()*quantity);
		
	}
	
	public double calculateTotal(){
		double sum = 0.0;
		
		for(Item i: map.keySet()){
			sum =sum+ Main.myCart.totalForItem(i, Main.myCart.getMap().get(i));
		}
		return (sum);
	}
	
		
	public static void printReceipt(ObservableList<Item> list) {
		BufferedWriter writer = null;
		try{
			int totalCount = 0;
			String str="";
			for(Item i : list) {
				str = str+i.toString()+"\n";
				totalCount+= i.getIQuantity();	
			}
			
			DecimalFormat df = new DecimalFormat(".00");
			str = str+"TOTAL,"+Integer.toString(totalCount)+","+df.format(CartController.Total);
			
			
			
		    writer = new BufferedWriter(new FileWriter("receipt"+Integer.toString(CartController.count)+".txt"));
		    writer.write(str);
		    
		    writer.flush();
		    writer.close();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(writer != null)
				writer = null;
		}
	}
	
//	public static void determineName() {
//		Path currentRelativePath = Paths.get("");
//		String path = currentRelativePath.toAbsolutePath().toString()+"/receipt.txt";
//		
//		Path filePath  = Paths
//		System.out.println(path);
//		
//		if(path+"/receipt")
//		
//		String s ="Receipt";
//		
//		//return s;
//		
//	}
	/**
	 * @return the map
	 */
	public  HashMap<Item, Integer> getMap() {
		return map;
	}


	/**
	 * @param map the map to set
	 */
	public void setMap(HashMap<Item, Integer> map) {
		this.map = map;
	}


}