import java.util.Scanner;

public class lbLinkedList_Dagsa {
    
    Node head; //head of the linked list

    static class Node {
        int employeeID;
        String employeeName;
        Node next;

        //Constructor for Node
        Node(int id, String name) {
            employeeID = id;
            employeeName = name;
            next = null;
        }
    }

    //display() method to display the Employees Name and ID in the iinked list
    public void displayEmployee() {

        Node new_node = head;

        if(new_node == null) {
            System.out.println("No employee to display");
        }
        
        while (new_node != null) {
            System.out.println(new_node.employeeID + " \t\t " + new_node.employeeName);
            new_node = new_node.next;
        }
    }

    //add() method to add Employee in the Linked List
     public void addEmployee(int id, String name) {
        
        Node new_node = new Node(id, name);

        if (head == null) {
            head = new_node;
        }
        else {
            Node current_node = head;
            while (current_node.next != null) {
                current_node = current_node.next;
            }
            current_node.next = new_node;
        }
    }
    
    //delete() method to delete Employee Name and ID in the Linked List
    public void deleteEmployee(int position) {
        
        if(head == null)
            return;

        Node temp = head;

        for (int i = 0; temp != null && i < position - 1 ; i++) 
            temp = temp.next;
            
        if (temp == null || temp.next == null)
            return;

        Node next = temp.next.next;
        temp.next = next;
    }

    //search() method to search Employee Name and returns true or false
    public boolean searchEmployee(Node head, String name) {

        Node new_node = head;

        while (new_node != null) {
            if (new_node.employeeName.equalsIgnoreCase(name)) 
                return true;

            new_node = new_node.next;
        }

        return false;
    }

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int choice = 0; //variable for choice
        lbLinkedList_Dagsa Llist = new lbLinkedList_Dagsa(); //Object to access linked list

        //10 employees
        Llist.addEmployee(1001, "Ralph");
        Llist.addEmployee(1002, "Raven");
        Llist.addEmployee(1003, "Richmond");
        Llist.addEmployee(1004, "Reiner");
        Llist.addEmployee(1005, "Renzel");
        Llist.addEmployee(1006, "Lyrielle");
        Llist.addEmployee(1007, "Justine");
        Llist.addEmployee(1008, "Kenneth");
        Llist.addEmployee(1009, "Ethan");
        Llist.addEmployee(1010, "Ervin");
        

        
        //Menu loop
        do {
            
            System.out.println("\n\n");
            System.out.println("============EMPLOYEE SYSTEM============");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Display");
            System.out.println("4. Search");
            System.out.println("5. Exit");
            System.out.println("=======================================");

            System.out.print("Enter choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n\n");
                    System.out.println("============INSERT============");
                    System.out.print("Enter Employee Name: ");
                    String insert_name = input.next();
                    System.out.print("Enter Employee ID: ");
                    int insert_id = input.nextInt();
                    Llist.addEmployee(insert_id, insert_name);
                    break;

                case 2:
                    System.out.println("\n\n");
                    System.out.println("============DELETE============");
                    System.out.print("Enter Employee List Position: ");
                    int delete_position = input.nextInt();
                    Llist.deleteEmployee(delete_position);
                    break;
                
                case 3:
                    System.out.println("\n\n");
                    System.out.println("============DISPLAY============");
                    System.out.println("Employee ID \t Employee Name");
                    Llist.displayEmployee();
                    break;
                
                case 4:
                    System.out.println("\n\n");
                    System.out.println("============SEARCH============");
                    System.out.print("Enter Employee Name: ");
                    String search_name = input.next();
                    if (Llist.searchEmployee(Llist.head, search_name)) {
                        System.out.println("============SEARCH============");
                        System.out.println(search_name + " is found!");
                    } else {
                        System.out.println("============SEARCH============");
                        System.out.println(search_name + " cannot be found!");
                    }
                    break;

                case 5:
                    System.out.println("\n\n");
                    System.out.println("Program exited.");
                    break;

                default:
                    System.out.println("\n\n");
                    System.out.println("ERROR! Invalid Input....");
                    break;
            }


        } while (choice != 5);

        input.close();

    }
}
