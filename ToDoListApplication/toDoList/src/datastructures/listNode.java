package datastructures;

/**
 *
 * @author rla
 */
public class listNode<E> {
    /**
     * This is the data we want to store,
     * It can be of any type
     */
    private E nodeData;   // Data we want to store (could be int, string, Object etc.)
    /**
     * This will hold the pointer to the next node in the list
     */
    private listNode<E> nextNode;  // A "pointer" to next node in the list

/**
 * constructor of the list node which initializes variables with null
 */
    public listNode (){
        this.nodeData = null;
        this.nextNode = null;
    }

    /**
     * parametrized constructor to populate the variables
     * @param nodeData
     *@param nextNode
     */
    public listNode(E nodeData, listNode<E> nextNode) {
        this.nodeData = nodeData;
        this.nextNode = nextNode;
    }

    /**
     * function which returns the data of the node
     * @returns the node data
     */
    public E getNodeData() {
        return nodeData;
    }

    /**
     * function to set the node data
     * @param nodeData
     */
    public void setNodeData(E nodeData) {
        this.nodeData = nodeData;
    }

    /**
     * function which returns the next node of the node
     * @returns next node
     */
    public listNode<E> getNextNode() {
        return nextNode;
    }

    /**
     * function to set the next node of the node
     * @param nextNode
     */
    public void setNextNode(listNode<E> nextNode) {
        this.nextNode = nextNode;
    }

    /**
     * function to return the tostring format of the object
     * @return String of node data
     */
    @Override
    public String toString(){
        return this.nodeData.toString();
    }
}
