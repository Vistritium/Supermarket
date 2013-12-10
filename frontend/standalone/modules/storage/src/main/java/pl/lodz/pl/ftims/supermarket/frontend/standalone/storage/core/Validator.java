package pl.lodz.pl.ftims.supermarket.frontend.standalone.storage.core;

import java.util.List;

import backend.api.StorageManagement;
import backend.core.model.Category;
import backend.core.model.Products;

public class Validator {
        
        private StorageManagement apiSM;
        
        public Validator(){
                this.apiSM= new StorageManagement();    
                
        }
        
        

        
        public boolean addProduct(String name,int idCategory, int idSupplier,String cena, String count){
        	
    		int errorCount=0;
    		char[] convertedName = name.toCharArray();
    		for(int i=0; i<convertedName.length; i++ ){
    			   if(!(convertedName[i] >= 'a' && convertedName[i] <= 'z' || convertedName[i] >= 'A' && convertedName[i] <= 'Z' ||convertedName[i] ==' ' || convertedName[i] =='-')) errorCount++;
    		}	      
    	
    int a;		
    try{
    	a = Integer.parseInt(cena);
    }  catch (NumberFormatException e){
    	return false;
    }
    
    int b;
    
    try{
    	b = Integer.parseInt(count);
    }  catch (NumberFormatException e){
        	return false;
        }
    		
    		if(errorCount==0) {
    			List<Category> cat= apiSM.getCategory();
    			
    			int index=-1;
    			
    			for(int i=0; i<cat.size(); i++){
    				if(cat.get(i).getIdCategory()==idCategory){
    					index=i;
    					break;
    				}
    			}
    			
    			if(apiSM.addProduct(new Products(name, cat.get(index), a, b, idSupplier))) return true;
    			else return false;
    		}
    		else
    		return false;

        }
        
        
        
        
        public boolean editProduct(int idProduct, String name,int idCategory, int idSupplier,String count){
        	return true;
        }
        
        
        
        
        public boolean removeProduct(int idProduct){
        	if(apiSM.removeProduct(idProduct)) return true;
        	else return false;
        }
        
        
        
        
        public boolean addCategory(String name){

        		int errorCount=0;
        		char[] convertedName = name.toCharArray();
        		for(int i=0; i<convertedName.length; i++ ){
        			   if(!(convertedName[i] >= 'a' && convertedName[i] <= 'z' || convertedName[i] >= 'A' && convertedName[i] <= 'Z' ||convertedName[i] ==' ' ||convertedName[i] =='-')) errorCount++;
        		}	      
        		
        		if(errorCount==0) {
        			if(apiSM.addCategory(new Category(name))) return true;
        			else return false;
        		}	


        	return false;
        }
        
        
        
        
        public boolean removeCategory(int idCategory){
        	if(apiSM.removeCategory(idCategory)) return true;
        	else return false;
        }
        
        
        
        
        public boolean editCategory(int idCategory, String name){
        	return true;
        }
        
        
        
        
        public boolean addSupplier(String name){
        	return true;
        }
        
        
        
        
        public boolean removeSupplier(int idSupplier){
        	if(apiSM.removeManufacturer(idSupplier)) return true;
        	else return false;

        }
        
        
        
        
        public boolean editSupplier(int idSupplier, String name){
        	return true;
        }
       
        
        
        
        
        public boolean sell(int idPriduct, String count){
        	return true;
        }
        
      
}