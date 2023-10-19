
import java.io.*;



public class ReadHtml {
	 StringStackImpl tag_stack = new StringStackImpl();
	 StringStackImpl tag_stack_close = new StringStackImpl();
	 
	 public void LoadFile (String file) {
		 File tag_file = null;
	     BufferedReader br = null;
	     String line;
	     String unedited_tag;
	     String tag;
	    
	     try {
	            tag_file = new File(file);	
	        } catch (NullPointerException e) {
	            System.err.println("Couldn't find the file...");
	        }	
	        try {
	            br = new BufferedReader(new FileReader(tag_file));
	        } catch (FileNotFoundException e) {
	            System.err.println("Couldn't open the file...");
	        }
	        try {
	        	line = br.readLine() ;
	        	
	        	while (line != null) {
	                    
	        		    String trimmed_line = line.trim();
	        			if (trimmed_line.contains("<"))   {                                
	                    
	        				int first = trimmed_line.indexOf("<");
	        				int next = first + 1;
	        				
	        				String checker = trimmed_line.substring(1);
	        				
	        				if (trimmed_line.charAt(next) != '/' ) {                                     
	        					unedited_tag = trimmed_line.substring(first); //afairei to <                    
	        					int last = unedited_tag.indexOf('>'); //pairnei to index toy >
	        					int cont = last + 1;                            
	        					tag = unedited_tag.substring( 1, last); 
	        					tag_stack.push(tag);  //pusharei to tag                       
	        					line = unedited_tag.substring(cont);                        
	        				} 
	        				else{
	                    	    unedited_tag = trimmed_line.substring(next + 1);                       
		                        int last = unedited_tag.indexOf('>');  // pairnei to index toy >                         
		                        tag = unedited_tag.substring(0, last); 
		                        int cont = last + 1;
		                        tag_stack_close.push(tag);
		                        
		                        if(tag_stack.peek().equals(tag)) {            
		                        	tag_stack_close.pop();  
		                        	tag_stack.pop();
		                        }
		                        line = unedited_tag.substring(cont); //proxoraei mhpws yparxei emfolvmeno tag
	                    	
	        				}
	        				
	        			}else {
       					line = br.readLine() ;	
	        			}
	        	}
	        	br.close() ;
	        	
	        	
	        	if(tag_stack.isEmpty() && tag_stack_close.isEmpty()) {
	        		System.out.println("The tags are linked correctly") ;
	        	}else {
	        		System.out.println("The tags are not linked correctly");
	        	}
	        }
	        catch (IOException e) {
				System.out.println ("Couldn't read the line...");
	        }
	        
	 }

	
}
