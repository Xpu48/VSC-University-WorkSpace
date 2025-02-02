import java.util.Scanner;

class Stacks { 

    Node head;  
      
    static class Node { 
        int data; 
        Node next; 
        Node(int d){
            data = d; 
            next=null;
        } 
    } 

   //PUSH inserts an element at the end of the stack
   public static Stacks PUSH(Stacks list, int data) 
    {
        // We create the new node 
        Node newNode = new Node(data); 
  
        //Now we link the node to the list 
        newNode.next=list.head;
        list.head=newNode;

       // Return the modified list 
        return list; 
    }

    //PEEK checks the last element inserted of the stack
    public static void PEEK(Stacks list)
    {
        Node tmp = list.head;
        if(tmp!=null)
          System.out.println("The last element inserted is: "+tmp.data);
        else
          System.out.println("The list is empty");
    }
    
   
    public static Stacks POP(Stacks list)
    {
       Node tmp = list.head;
        if(tmp!=null)
        {
          list.head=tmp.next;
          System.out.println("The element deleted is: "+tmp.data);
        }
        else
          System.out.println("The list is empty");
        return list;
    }

    public static boolean ISEMPTY(Stacks list)
    {
        if(list.head==null)
          return true;
        else
          return false;
    }
   
    //Display the content of the whole list
    public static void printList(Stacks list) 
    { 
        Node tmp = list.head; 
        if(tmp!=null)
         {
           System.out.println("The content of the list is:");
           // Traverse the list 
           while (tmp != null) { 
            // Print the data at current node 
            System.out.print(tmp.data); 
    
            // Move to next node 
            tmp = tmp.next; 
            if(tmp!= null)
                   System.out.print("->");
        } 
        System.out.println("");
        }
        else
           System.out.println("The list is empty");
    }


    public static void main(String[] args) 
    { 
        //create a new list
        Stacks list = new Stacks(); 

        //Create variable to read from keyboard
        Scanner in=new Scanner(System.in);
        int option, x;
        
        
        do
       {
         System.out.println("Select your option:");
         System.out.println("0: Quit the programme");
         System.out.println("1: Insert PUSH an element into the stack");
         System.out.println("2: Remove POP an element from the end of the stack");
         System.out.println("3: Checks PEEK checks the last element inserted of the stack");
         System.out.println("4: Check ISEMPTY returns true if the stack is empty");
    
         option=in.nextInt();
         if(option==1)
         {
           System.out.println("What number do you want to insert?");
           x=in.nextInt();
           list=PUSH(list, x);
           printList(list);
         }

         if(option==2)
         {
            list=POP(list);
            printList(list);
         }
         
         if(option==3)
             PEEK(list);
        
        if (option == 4)
            System.out.println("Is the Stack Empty?: " + ISEMPTY(list));

        if(option==0)
          System.out.println("Good bye!"); 
        }while(option!=0);
        in.close();
    }
  }