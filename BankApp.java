/* Author: Yaman Malik
https://github.com/yamanmalik
*/

public class BankApp {

    public Bank bank;

   

    /** Creates a new instance of BankApp */

    public BankApp() {

        bank = new Bank();

    }


    /**

     * @param args the command line arguments

     */

    public static void main(String[] args) {

        // TODO code application logic here

        BankApp bankApp = new BankApp();

        BankGUI gui = new BankGUI();

        gui.processCommands(bankApp.bank);

       

       

    }

   

}
