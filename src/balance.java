
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author islam
 */
public class balance extends Model{
    private  int user_id ;
      private  double balance ;

    public balance(){
     this.table = "balances";
     this.columns = new String[]{"user_id", "balance"};
    }

   public balance(int  user_id , double balance){
     this.table = "balances";
     this.columns = new String[]{"user_id", "balance"};
     this.user_id = user_id;
     this.balance = balance; 
      this.values = new Object[]{this.user_id,this.balance};
    }
   
 public  void update(int id) {
        try {
            DBConnection conn = new DBConnection();
            int row = conn.update(table, columns, values , "user_id=" + id);
            conn.close();
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
 
    
}
