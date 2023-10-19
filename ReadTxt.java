

import java.io.*;

public class ReadTxt{

IntQueueImpl<Integer> stock_queue = new IntQueueImpl<>(); // queue gia ta stock
IntQueueImpl<Integer> price_queue = new IntQueueImpl<>(); // queque gia tis times twn antistoixwn stock


  public void LoadFile(String file) {
	  
	File stock_file = null; 
	FileReader fr = null;
	BufferedReader br = null;
	String line;
	
	String type; // typos toy text (buy or sell)
	int stock; //to amount toy stock poy vrethike sto file
	int price; //h price poy vrethike sto file
	int buy_stock; //to poso toy stock poy agorasthke
	int buy_price; //h price toy stock poy molis agorasthke
	int sell_stock; //to poso toy stock poy pwleitai
	int sell_price; //h price toy stock poy pwleitai
	int total_stock = 0; //synolikh timh toy stock poy agorasthke
	int remaining_stock = 0; //to synoliko stock pou apomenei apthn prohgoymenh get
	int remaining_price = 0; //h price toy stock poy apomenei apthn prohgoymenh get
	int current_stock; // to stock mprosta stin queue
	int current_price; // h price mporsta stin queue
	int final_result = 0; // to synoliko kerdos h zhmia meta apo oles tis diadikasies buy h sell
	
	
	try {
        stock_file = new File(file);	
    } catch (NullPointerException e) {
        System.err.println("Couldn't find the file...");
    }// prospathise na vreis to file, an den to vreis peta error

    try {
    	fr = new FileReader(stock_file);
        br = new BufferedReader(fr);
    } catch (FileNotFoundException e) {
        System.err.println("Couldn't open the file...");
    }// prospathise na anoikseis to file, an den mporeis peta to error
    
    try {
    	line = br.readLine();
    	
    	while(line != null) {
    		
    		String word[] = line.split(" "); // splitarw 
    		
    		type = word[0]; // krataw thn prwth timh toy file sthn metavlhth type
    		stock = Integer.parseInt(word[1]); //krataw thn posothta toy stock sthn metavlhth stock
        	price = Integer.parseInt(word[3]); // krataw thn timh toy stock sthn metavlhth price
        	
    		if(type.equalsIgnoreCase("buy")) {
    			
    			buy_stock = stock; // thetw thn posothta toy stock poy vrhka panw sto file ws thn posothta poy agorasthke
    			buy_price = price; // thetw thn timh poy vrethke panw ws thn timh poy agorasthke to parapanw stock
        		
        		stock_queue.put(buy_stock);// bazw to stock poy agorasthke mesa sthn oyra twn stock
        		price_queue.put(buy_price);// bazw thn timh poy agorasthke to parapanw stock mesa sthn oyra twn timwn
        		
        		total_stock += buy_stock; // ayksanw thn synolikh posothta stocks kathe fora poy agorazw me thn posothta poy agorazw
        		
             }else if(type.equalsIgnoreCase("sell")) {
    			
            	int result = 0; // to apotelesma mias pwlhshs
            	sell_stock = stock; // thetw thn posothta toy stock poy vrhka panw sto file ws thn posothta poy pwleithike
    			sell_price = price; // thetw thn timh poy vrethke panw ws thn timh poy pwleithike to parapanw stock
    			
    			if(total_stock < sell_stock) { // an to poso twn stock poy thelw na poylhsw einai mikrotero aytwn poy exw
    				System.out.println("You don't have enough stocks to sell");
    			}else { //alliws
    				
    	          while(sell_stock != 0) {
    	        	  
    	        	  if(remaining_stock == 0) { 
    	        		  
    	        		  current_stock = stock_queue.get(); // pernw to stock mprosta sthn oyra
    	        		  current_price = price_queue.get(); // pernw thn timh toy stock poy vrisketai mprosta sthn oyra apthn oyra twn timwn
    	        		  
    	        		  if(current_stock > sell_stock) {
    	        			
    	        		   result += sell_stock*(sell_price - current_price);	  
       	        		   total_stock -= sell_stock;
    	        		   remaining_stock = current_stock - sell_stock;
       	        		   remaining_price = current_price;
       	        		   sell_stock = 0;  	        			  
    	  
    	        		  }else {
    	                   total_stock -= current_stock;
 	        			   sell_stock -= current_stock;
 	        			   result += current_stock* (sell_price - current_price);
    	        
    	        		  }//if current stock > of the stock we want to sell
    	        		  
    	        	  }else {
    	        		  
    	        		  if(sell_stock >= remaining_stock) {
    	        			 
    	        			  result += remaining_stock*(sell_price - remaining_price);
    	        			  sell_stock -= remaining_stock;
    	        			  remaining_stock = 0;
    	        			  
    	        		  }else {
    	        			  
    	        			  result += sell_stock*(sell_price - remaining_price);
    	        			  remaining_stock -= sell_stock;
    	        			  sell_stock = 0;
    	        		  }// if sell stock >= of the remaining stock
    	        		  
    	        		  
    	        	  }// if remaining stock = 0	  
    	        	
    	          }// while sell_stock
    	        final_result += result; //prosthetei to apotelesma kathe sell se mia metvalhth
    	        
    	        
    			}// if total stock is less than the one you want to sell
    			
    		 }// if type equals buy or sell
    		
    		line = br.readLine();
    		
    	}//while line != null
    	
    	br.close();
    	
    	if(final_result>0) {
    		
    	        System.out.println("The profit is: "+ final_result);
    	        }else if(final_result<0) {	
    	        System.out.println("The loss is: "+ (-final_result));
    	        }else {
    	        System.out.println("There is no profit nor loss in this scenario");
    	        } // printarei to synoliko kerdos h zhmia meta ap oles tis sell diadikasies
    	
    }//try reading line
                
    catch(IOException e) {
    	System.out.println("Couldn't read the line...");
    }//IOException
    
  }//LoadFile
  
  
}//ReadFile