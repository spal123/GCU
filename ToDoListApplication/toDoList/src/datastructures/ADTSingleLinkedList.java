package datastructures;

/**
 *
 * @author rla
 */
public class ADTSingleLinkedList<E> implements IADTLinkedList<E> {

    private listNode<E> head; // This will be null if empty or point to the top of the list
    private int listSize;      // This will maintain the size of the list

    // Constructor
    public ADTSingleLinkedList() {
        this.head = null;
        this.listSize = 0;
    }

    /**
     * this function finds the length of the linked list
     * @return the size of the linked list
     */
    @Override
    public int length() {
        return listSize;
    }

    /**
     * function to check if the linked list is empty 
     * @return boolean true or false
     */
    @Override
    public boolean isEmpty() {

        return head == null;
    }

    /**
     * function to create the list
     */
    @Override
    public void createList() {

    }

    /**
     * function to print the linked list 
     */
    @Override
    public void printList() {
        if (isEmpty()) {
            System.out.println("\nTask List is Empty");
        } else {
            listNode<E> temp = head;
            while (temp != null) {
                System.out.println(temp.getNodeData().toString());
               temp= temp.getNextNode();
            }
        }
    }

    /**
     * function to find the head of the linked list
     * @return returns the node type pointer of head
     */
    @Override
    public listNode<E> front() {

        return head;
    }

    /**
     * function to insert the node in to the linked list
     * @param theNode which has to be inserted 
     */
    @Override
    public void insert(E theNode) {
        if (isEmpty()) {
            listNode<E> newNode = new listNode<>(theNode, null);
            head = newNode;
            listSize++;

        } else {
            listNode<E> temp = head;
            while (temp.getNextNode() != null) {
                temp = temp.getNextNode();
            }
            listNode<E> newNode = new listNode<>(theNode, null);
            temp.setNextNode(newNode);
            listSize++;
        }

    }

    /**
     * function to remove the node from the linked list
     * @param theNode which needs to be removed
     */
    @Override
    public void remove(E theNode) {
        listNode<E> previousNode = null;
        listNode<E> currentNode = this.head;
        while (currentNode != null) {
            if (theNode.equals(currentNode.getNodeData())) {
                // found the node that needs to be removed
                if (previousNode == null) {
                    // must be removing the first node in the list
                    this.head = currentNode.getNextNode();
                } else {
                    // removing a node that’s not first in list
                    previousNode.setNextNode(currentNode.getNextNode());
                }
                System.out.println("Removing item ...");
                this.listSize--;
            } else {

                previousNode = currentNode;
            }
            currentNode = currentNode.getNextNode();
        }
    }

    /**
     * function to remove the node from linked list using index
     * @param index poisiton where node has to be deleted
     * @return pointer of the node to be deleted
     */
    @Override
    public listNode<E> remove(int index) {
        listNode<E> previousNode = null;
        listNode<E> currentNode = this.head;
        listNode<E> rtnNode = null;
        boolean stop = false;
        int count = 1;
        while (!stop) {
            if (count == index) {

                rtnNode = currentNode;
                stop = true;
            } else {
                count++;
                currentNode=currentNode.getNextNode();
            }
          
        }

        return rtnNode;
    }

    /**
     * function which finds if the node to be deleted exists in linked list or not
     * @param theNode which needs to be deleted
     * @return boolean true or false 
     */
    @Override
    public boolean find(E theNode) {
        listNode<E> tmp = this.head;
        while (tmp != null) {
            if (theNode.equals(tmp.getNodeData())) {
                return true;
            }
            tmp = tmp.getNextNode();
        }
        return false;
    }

    /**
     * function to find the node using the last name
     * @param theLastName
     * @return pointer to the node
     */
    @Override
    public listNode<E> find(String theLastName) {
        // Add your code here
        return null;  // Add your return value here
    }

}
