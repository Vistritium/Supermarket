package pl.lodz.pl.ftims.supermarket.frontend.standalone.storage.core;

import java.util.ArrayList;
import java.util.List;

import backend.api.StorageManagement;
import backend.core.model.Category;
import backend.core.model.Manufacturers;
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
            
    float a;                
    try{
            a = Float.parseFloat(cena);
    }  catch (NumberFormatException e){
            return false;
    }
    if(a<0) return false;
    int b;
    
    try{
            b = Integer.parseInt(count);
    }  catch (NumberFormatException e){
                return false;
        }
    if(b<0) return false;  
    
                    if(errorCount==0) {
                            List<Category> cat= apiSM.getCategory();
                            
                            int index=-1;
                            
                            for(int i=0; i<cat.size(); i++){
                                    if(cat.get(i).getIdCategory()==idCategory){
                                            index=i;
                                            break;
                                    }
                            }
                            
                            if(apiSM.addProduct(new Products(name, cat.get(index), b, a, idSupplier))) return true;
                            else return false;
                    }
                    else
                    return false;

        }
        
        
        
        
        public boolean editProduct(int idProduct, String name,int idCategory, int idSupplier,String cena, String count){
            int errorCount=0;
            char[] convertedName = name.toCharArray();
            for(int i=0; i<convertedName.length; i++ ){
                       if(!(convertedName[i] >= 'a' && convertedName[i] <= 'z' || convertedName[i] >= 'A' && convertedName[i] <= 'Z' ||convertedName[i] ==' ' || convertedName[i] =='-')) errorCount++;
            }              
    
            float a;                
            try{
            	a = Float.parseFloat(cena);
            }  catch (NumberFormatException e){
            	return false;
            }
            if(a<0) return false;
            int b;

            try{
            	b = Integer.parseInt(count);
            }	catch (NumberFormatException e){
            	return false;
            }
            if(b<0) return false;  

            if(errorCount==0) {
                    List<Category> cat= apiSM.getCategory();
                    
                    int index=-1;
                    
                    for(int i=0; i<cat.size(); i++){
                            if(cat.get(i).getIdCategory()==idCategory){
                                    index=i;
                                    break;
                            }
                    }
                    
                    apiSM.editProduct(new Products(name, cat.get(index), b, a, idSupplier));
                    return true;
            }
            else
            return false;

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
        
        
        
        
        public boolean editCategory(int idCategory, String name){ //nie mialem pomyslu co zrobić z tym id, ale powinno działać (raczej);/
        	  int errorCount=0;
              char[] convertedName = name.toCharArray();
              for(int i=0; i<convertedName.length; i++ ){
                         if(!(convertedName[i] >= 'a' && convertedName[i] <= 'z' || convertedName[i] >= 'A' && convertedName[i] <= 'Z' ||convertedName[i] ==' ' ||convertedName[i] =='-')) errorCount++;
              }              
              
              if(errorCount==0) {
            	  	Category cat = new Category(name);
            	  	cat.setIdCategory(idCategory);   //id wciśnięte tutaj
                      apiSM.editCategory(cat);
                      return true;
              }       
        	return false;
        }
        
        
        
        
        public boolean addSupplier(String name){
        	
            int errorCount=0;
            char[] convertedName = name.toCharArray();
            for(int i=0; i<convertedName.length; i++ ){
                       if(!(convertedName[i] >= 'a' && convertedName[i] <= 'z' || convertedName[i] >= 'A' && convertedName[i] <= 'Z' ||convertedName[i] ==' ' ||convertedName[i] =='-')) errorCount++;
            }              
            
            if(errorCount==0) {
                    apiSM.addManufacturer(new Manufacturers(name));
                    return true;
            } 
            
            
                return false;
        }
        
        
        
        
        public boolean removeSupplier(int idSupplier){
                if(apiSM.removeManufacturer(idSupplier)) return true;
                else return false;

        }
        
        
        
        
        public boolean editSupplier(int idSupplier, String name){ //na zasadzie editCategory
      	  int errorCount=0;
          char[] convertedName = name.toCharArray();
          for(int i=0; i<convertedName.length; i++ ){
                     if(!(convertedName[i] >= 'a' && convertedName[i] <= 'z' || convertedName[i] >= 'A' && convertedName[i] <= 'Z' ||convertedName[i] ==' ' ||convertedName[i] =='-')) errorCount++;
          }              
          
          if(errorCount==0) {
        	  Manufacturers sup = new Manufacturers(name);
        	  	sup.setIdManufacturer(idSupplier);  //id wcisniete tutaj
                  apiSM.editManufacturer(sup);
                  return true;
          }       
          return false;
        }
       
        
        
        
        public boolean sell(int idPriduct, String count){
                return true;
        }
        
        public List<Products> searchProducts(String name, int categoryId, int supplierId){
        	List<Products> result= new ArrayList<>();
        	
        	result=apiSM.getProducts();
        	
        	if(!name.isEmpty()){
        		for(int i=0; i<result.size(); i++)
        			if(!result.get(i).getName().toUpperCase().equals(name.toUpperCase())){
        				result.remove(i);
        				i--;
        			}
        	}
        	if(categoryId!=-1){
        		for(int i=0; i<result.size(); i++){
        			if(result.get(i).getCategory().getIdCategory()!=categoryId){
        				result.remove(i);
        				i--;
        			}
        		}
        	}
        	if(supplierId!=-1){
        		for(int i=0; i<result.size(); i++){
        			if(result.get(i).getManufacturer()!=supplierId){
        				result.remove(i);
        				i--;
        			}
        		}

        	}
        	
        	
        	return result;
        }
        
      
}