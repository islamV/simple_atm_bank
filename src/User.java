
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class User extends Model {
    private String name, card_number, password;
    private int id ;

    User( String name, String phone, String password) {
        this.table = "users";
        this.columns = new String[]{"name", "card_number", "password"};
        this.name = name;
        this.card_number = phone;
        this.password = password;
        this.values = new String[]{this.name, this.card_number, this.password};
    }
      User( ) {
                  this.table = "users";
                  this.columns = new String[]{"name", "card_number", "password"};

      }
public String getName(){
    return this.name ;
}
public String getPassword(){
    return this.password ;
}
public String getCard_number (){
    return this.card_number ;
}

public void setId(int id ){
    this.id = id ;
}    
public int getId( ){
  return  this.id ;
}  
public double balance(){
     String selectQuery = "SELECT * FROM balances WHERE user_id = "+ this.id;
     double balance =0 ;
             try {
     DBConnection conn =  new DBConnection();
     ResultSet r =  conn.query(selectQuery) ;
     if(r.next()){
         balance = r.getFloat("balance");
     }
     } catch (SQLException e) {
        System.out.println("SQL Exception: " + e.getMessage());
    } catch (ClassNotFoundException e) {
        System.out.println("Exception: " + e.getMessage());
        // Log or handle the exception appropriately
    }
             return balance ;
}
public void withdrawal(double amount){
      new balance(getId(), amount).update(getId());
}
public void deposit(double amount){
      new balance(getId(), amount).update(getId());
}

    public static void main(String[] args) {
//        User user = new User("test", "1234", "123456");
//        user.create();
    }
}
