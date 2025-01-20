import java.util.Scanner;

class LinkedList { 

    Node head;  
      
    static class Node { 
        int data; 
        Node next; 
  
        Node(int d){
            data = d; 
            next=null;
        } 
    } 

   //Insert node at the beginning of the list 
   public static LinkedList insert_start(LinkedList list, int data) 
    { 
        // We create the new node 
        Node newNode = new Node(data); 
  
        //Now we link the node to the list 
        newNode.next=list.head;
        list.head=newNode;

       // Return the modified list 
        return list; 
    }

    public static LinkedList insert_end(LinkedList list, int data)
    {
        Node newNode = new Node(data);
        Node tmp = list.head;
        if(tmp == null)
        {
            list.head = newNode;
            return list;
        }
        while(tmp.next != null)
        {
            tmp = tmp.next;
        }
        tmp.next = newNode;
        return list;
    }

    //Display the content of the linked list 
    public static void printList(LinkedList list) 
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
   
    // Calculate the length of the linked list
    public static int length(LinkedList list){
        Node tmp = list.head;
        int count = 0;
        while(tmp != null){
          count++;
          tmp = tmp.next;
        }
        return count;
    }

    public static void PrintListK(LinkedList list, int K){
        if (K < 0){
          System.out.println("K cannot be negative");
          return;
        }
        Node tmp = list.head;
        int count = 0;
        while(tmp != null && count < K){
          System.out.println(tmp.data);
          tmp = tmp.next;
          count++;
        }
      }

    public static void showDuplicates(LinkedList list, int x){
        Node tmp = list.head;
        int count = 0;
        while(tmp != null){
          if (tmp.data == x){
            count++;
          }
          tmp = tmp.next;
        }
        System.out.println("The number " + x + " appears " + count + " times in the list");
      }

      public static int max(LinkedList list){
        Node tmp = list.head;
        int max = Integer.MIN_VALUE;
        while(tmp != null){
          if (tmp.data > max){
            max = tmp.data;
          }
          tmp = tmp.next;
        }
        return max;
      }
    
      public static void TrueOrFalse(LinkedList list, int x){
        Node tmp = list.head;
        while(tmp != null){
          if (tmp.data == x){
            System.out.println("True");
            return;
          }
          tmp = tmp.next;
        }
        System.out.println("False");
      }

    public static LinkedList deleteAll(LinkedList list){
        list.head = null;
        return list;
    }

    //Delete the first element with data part equal to x
    public static LinkedList delete(LinkedList list, int x)
   {
     Node tmp=list.head;
     Node prev;

     if(tmp==null)
         {System.out.println("There is nothing to delete");
         return list; }
      else
      {

         //Case 1: x is found in the first node
         if(tmp.data==x)
         {
          list.head=tmp.next; //head points to the second element
          return list;
         }

         else   //Case 2: X is not in the first position, we must keep searching
         {
         prev=tmp;
         tmp=tmp.next;
         while(tmp!=null)
          {
             if(tmp.data==x)
              {
                 prev.next=tmp.next;
                 return list;
               }
             prev=tmp;
             tmp=tmp.next;
           }   
          }
         System.out.println("Element not found");
        return list;
    }

}



    public static void main(String[] args) 
    { 
        //create a new list
        LinkedList list = new LinkedList(); 

        //Create variable to read from keyboard
        Scanner in=new Scanner(System.in);
        int option, x;
        
        
        do
       {
         System.out.println("Select your option:");
         System.out.println("0: Quit the programme");
         System.out.println("1: Insert an element to the beginning of the list");
         System.out.println("2: Delete an element to the list");
         System.out.println("3: Print the content of the list");
         System.out.println("4: Print the length of the list");
         System.out.println("5: Print specific amount of elements from the list");
         System.out.println("6: Enter a element from the list to show duplicates");
         System.out.println("7: True or False if x is in the list");
         System.out.println("8: Insert an element to the end of the list");
         System.out.println("9: Delete all the element of the list");
         System.out.println("10: Return the Max value of the list");
         System.out.println("11: Delete the first element of the list");
    
         option=in.nextInt();
         if(option==1)
         {
           System.out.println("What number do you want to insert?");
           x=in.nextInt();
           list=insert_start(list, x);
           printList(list);
         }

         if(option==2)
         {
           System.out.println("What number do you want to delete?");
           x=in.nextInt();
           list=delete(list, x);
           printList(list);
         }
         
         if(option==3)
             printList(list);
        
        if (option == 4)
            System.out.println("The length of the list is: " + length(list));
        
        if (option == 5) {
            System.out.println("How many elements do you want to print?");
            int K = in.nextInt();
            PrintListK(list, K);
        }

        if (option == 6)
        {
            System.out.println("Enter a number to show duplicates");
            x = in.nextInt();
            showDuplicates(list, x);
        }
        
        if (option == 7)
        {
            System.out.println("Enter a number to check if it is in the list");
            x = in.nextInt();
            TrueOrFalse(list, x);
        }
        
        if (option == 8)
        {
            System.out.println("What number do you want to insert?");
            x = in.nextInt();
            list = insert_end(list, x);
            printList(list);
        }

        if (option == 9)
        {
            list = deleteAll(list);
            printList(list);
        }

        if (option == 10)
        {
            System.out.println("The max value of the list is: " + max(list));
        }

        if (option == 11)
        {
            list = delete(list, list.head.data);
            printList(list);
        }


        if(option==0)
          System.out.println("Good bye!"); 
        }while(option!=0);
        in.close();
    }
  }