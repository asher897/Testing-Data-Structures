import java.lang.NullPointerException;
public class AVLTree extends BinarySearchTree {
    private int balanceFactor;

    public AVLTree (BinaryNode node) {
        super(node);
        this.balanceFactor = 0;

    }

    public AVLTree() {
        super();
        this.balanceFactor = 0;
    }


    public int height(BinaryNode node){
      if(node != null){
        return node.height;
      }return -1;
    }

    /**Returns the balance factor for the given node
    *
    *@param p the node for which the balance factor is returned
    *@return an int value that is the balance factor
    *@throws NullPointerException
    */
    public int balanceFactor(BinaryNode p) throws NullPointerException{
            return height(p.right) - height(p.left);
    }

    /**
    *Fixes the height of the given node
    *
    *@param node the node for which the height will be fixed
    */
    public void fixHeight(BinaryNode node) {
        node.height = (Math.max(getHeight(node.left), getHeight(node.right))+1);
    }

    /**
    *Rotates the tree left correct an imbalance
    *
    *@param parent is the node at which there is an imbalance
    *@return the node which is now the root of the subtree that previously had the imbalance
    */
    public BinaryNode rotateLeft(BinaryNode parent) {
        BinaryNode child = parent.right;
        parent.right = child.left;
        child.left = parent;
        fixHeight(parent);
        fixHeight(child);
        return child;
    }

    /**
    *Rotates the tree right correct an imbalance
    *
    *@param parent is the node at which there is an imbalance
    *@return the node which is now the root of the subtree that previously had the imbalance
    */
    public BinaryNode rotateRight(BinaryNode parent) {
        BinaryNode child = parent.left;
        parent.left = child.right;
        child.right = parent;
        fixHeight(parent);
        fixHeight(child);
        return child;
    }

    /**
    *Performs either a signle or double rotation to correct an imbalance
    *
    *@param parent is the node at which there is an imbalance
    */
    public BinaryNode balance(BinaryNode parent) {
        fixHeight(parent);
        int bal = balanceFactor(parent);
        if(bal==2) {
          if(balanceFactor(parent.right)<0) {
            parent.right = rotateRight(parent.right);}
          return rotateLeft(parent);
          }
          if (bal==-2){
            if (balanceFactor(parent.left)>0){
              parent.left = rotateLeft(parent.left);
            }
            return rotateRight(parent);
          }
          return parent;
    }

    /**
    *inserts a node into the tree at the next available & correct placement
    *
    *@param items the three different items of type String that will be the data keys of the new inserted node
    */
    public void insertNode(String item, String itemTwo, String itemThree){
      this.insertCount++;
      root =  insertNode(item, itemTwo, itemThree, root);
    }

    /**
    *inserts a node into the tree at the next available & correct placement
    *
    *@param items the three different items of type String that will be the data keys of the new inserted node
    *@param node the node from which the function will start looking for a placement
    */
    public BinaryNode insertNode(String itemOne, String itemTwo, String itemThree, BinaryNode node){
        this.insertCount++;
        if (node == null){
          return new BinaryNode(itemOne, itemTwo, itemThree);
        }
        this.insertCount++;
        if(itemOne.compareTo(node.dataSet[0])<=0) {
          node.left = insertNode(itemOne, itemTwo, itemThree, node.left);
            }
        else {
          node.right =insertNode(itemOne, itemTwo, itemThree, node.right);

            }
        return balance(node);
    }

  }
