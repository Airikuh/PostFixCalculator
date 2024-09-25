//Erika Valle-Baird 
//CIS 296
//Project 3
//11/19/2021

package PostFixCalculator;

//Class to Allow our Calculations to be Done With a Stack
public class Stack {
    //Pointer to Top of the Stack
    private Node topStack;
    //Total Number of Entries in the Stack
    private int total;
    
    //Remove Top Item in Stack and Return to Caller
    public Object pop(){
        Node delete = new Node();
        if(topStack != null){
            delete.setData(topStack.getData());
            topStack = topStack.getNext();
            total--;
        }
        return delete.getData();
    }
    
    //Push Item onto the Stack
    public void push(Object elementsData){
        Node addNode = new Node(elementsData);
        //If stack has at least one element
        if(topStack != null){
            addNode.setNext(topStack);
            topStack = addNode;
        }
        //If Stack is empty
        if(topStack == null){
            topStack = addNode;
        }
        //Increase size of stack by adding node to it
        if(topStack.getData() == addNode.getData()){
            total++;

        }
        
    }
    
    //Determine if the Stack is Empty or Not
    public boolean isEmpty(){
        return(total==0);
    }
    
    
    //Determine Size of the Stack
    public int size(){
        return total;
    }
    
}
