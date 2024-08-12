import java.util.ArrayList;
import java.util.Scanner;

class contact{
    private String name;
    private String email;
    private String phoneNumber;

    public  contact(String name, String email, String phoneNumber){
        this.name=name;
        this.email=email;
        this.phoneNumber=phoneNumber;
    }
    public String getName(){
        return name;
    }

     public void setName(String name) {
         this.name = name;
     }
     public String getEmail(){
        return email;
     }

     public void setEmail(String email) {
         this.email = email;
     }

     public String getPhoneNumber() {
         return phoneNumber;
     }

     public void setPhoneNumber(String phoneNumber) {
         this.phoneNumber = phoneNumber;
     }

     @Override
     public String toString() {
         return "Name : "+name +"\n Email : "+email + "\n PhoneNumber : "+phoneNumber;
     }
 }

public class ContactManagementSystem {
    private static ArrayList<contact> contacts= new ArrayList<>();
    private static Scanner dora= new Scanner(System.in);

    public static void main(String[] args) {
        while (true){
            System.out.println("\n Welcome To Java Contact Manager ");
            System.out.println("1. Add a Contact");
            System.out.println("2. View a Contact");
            System.out.println("3. Edit a Contact");
            System.out.println("4. Delete a contact ");
            System.out.println("5. Exit");
            System.out.println(" Choose The Option from Below");
            int option= dora.nextInt();
            dora.nextLine();

            switch (option){
                case 1 :
                    addcontact();
                    break;
                case 2:
                     viewcontact();
                     break;
                case 3 :
                    editcontact();
                    break;
                case 4 :
                    deletecontact();
                case 5 :
                    System.out.println("Good BYE!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option Please Choose Correct Option");
                    break;
            }
        }
    }
    private  static void addcontact(){
        System.out.print("Enter The Contact Name : ");
        String name = dora.nextLine();
        System.out.print("Enter Mailid : ");
        String email=dora.nextLine();
        System.out.print("Enter PhoneNumber : ");
        String phone =dora.nextLine();

        contact contact= new contact(name,phone,email);
        contacts.add(contact);
        System.out.println("Contact added Succesfully");
    }

    private static void  viewcontact(){
        System.out.println("Contact : ");
        for(int i=0; i< contacts.size(); i++){
            System.out.println("Contact " + (i + 1) + ":\n" + contacts.get(i));

        }
    }
    private static  void  editcontact(){
        System.out.print("Enter the index of the contact you want to edit: ");
        int index = dora.nextInt();
        dora.nextLine();
        if(index>=1 && index<= contacts.size()){
            contact contact = contacts.get(index-1);
            System.out.print(" Enter New Phone No : ");
            String phonenumber= dora.nextLine();
            System.out.print(" Enter New Mail : ");
            String mail=dora.nextLine();

            contact.setPhoneNumber(phonenumber);
            contact.setEmail(mail);
            System.out.println("Contact update Successfully");
        }
    }
    private static void deletecontact() {
        System.out.print("Enter the index of the contact you want to delete: ");
        int index = dora.nextInt();
        dora.nextLine(); // Consume the newline character

        if (index >= 1 && index <= contacts.size()) {
            contact contact = contacts.remove(index - 1);
            System.out.println("Contact deleted:\n" + contact);
        } else {
            System.out.println("Invalid index. No contact found.");
        }
    }
}