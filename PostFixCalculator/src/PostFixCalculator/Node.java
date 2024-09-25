//Erika Valle-Baird 
//CIS 296
//Project 3
//11/19/2021

package PostFixCalculator;

//Class to Store the Stack in Nodes
public class Node {
    //Link to the Next Node
    private Node next;
    //An Entry in The Stack
    private Object data;
    
    //Default Constructor
    public Node(){
        this(null,null);
    }
    
    //Constructor With Only One Parameter
    public Node(Object elementsData){
        this(elementsData,null);
    }
    
   //Constructor With Only One Parameter
    public Node(Node nextElement){
        this(null, nextElement);
    }
    
    
    //Constructor With Both Parameters
  public Node(Object elementsData, Node nextElement){
      data = elementsData;
      next = nextElement;
  }
  
  //Get and Set Methods for Our Variables
  public Object getData(){
      return data;
  }
  
  public void setData(Object elementsData){
      data = elementsData;
  }
    
  public Node getNext(){
      return next;
  }
    
  public void setNext(Node nextElement){
      next = nextElement;
  }
    
}
