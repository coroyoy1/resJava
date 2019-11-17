package simplejava;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import simplejava.Customer.CustomerGUI;
import simplejava.Restaurant.RestaurantGUI;

public class SimpleJAVA {
    
    public static void main(String[] args) {
        LoginGUI user = new LoginGUI();
        user.setVisible(true);
    }
    
    //login method
    public void loginMethod(String username, String password)
    {
        String pathfile = "D:\\Users\\Coroy\\Documents\\NetBeansProjects\\simpleJAVA\\databaseCSV\\user_header_file.csv";
        String line = "";
        String[] accountUser = {};
        boolean exists = false;
        try(BufferedReader br = new BufferedReader(new FileReader(pathfile))){
            while((line = br.readLine())!= null){
                accountUser = line.split(",");
                if(username.equals(accountUser[1]) && password.equals(accountUser[2])){
                    if(accountUser[3].equalsIgnoreCase("customer")){
                        CustomerGUI cust = new CustomerGUI();
                        cust.setVisible(true);
                    }
                    else if(accountUser[3].equalsIgnoreCase("restaurant")){
                        RestaurantGUI res = new RestaurantGUI();
                        res.setVisible(true);
                    }
                    else{
                        System.out.println("User type does not exists");
                    }
                    exists = true;
                }
            }
            if(exists == false){
                System.out.println("User is not exists");
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }         
    }
}
