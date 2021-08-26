public class BinarySearchTree {
    public BinaryNode root;
    public int count;
    public int insertCount = 0;

    public BinarySearchTree(BinaryNode node) {
        this.root = node;
    }

    public BinarySearchTree() {
        this.root = null;
    }

    /**
    *Returns the height of the tree/subtree at the given node
    *
    *@param node the node that the hieght will be calculated for
    *@return an int value that is the height of the tree/subtree
    */
    public int getHeight() {
        return getHeight(root);
    }

    /**
    *Returns the height of the tree/subtree at the given node
    *
    *@param node the node that the hieght will be calculated for
    *@return an int value that is the height of the tree/subtree
    */
    public int getHeight(BinaryNode node) throws NullPointerException{
        if (node != null) {
          return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
        }else {
          return -1;
        }
    }
    /**
    *Returns the size of the tree/subtree at the given node
    *
    *@param node the node that the size will be calculated for
    *@return an int value that is the size of the tree/subtree
    */
    public int getSize(BinaryNode node) {
        if(node == null) {
            return 0;
        }else {
            return 1 + getSize(node.getLeft()) + getSize(node.getRight());
        }
    }

    /**
    *Returns the size of the tree/subtree at the given node
    *
    *@param node the node that the size will be calculated for
    *@return an int value that is the size of the tree/subtree
    */
    public int getSize() {
        return getSize(root);
    }

    /**
    *inserts a node into the tree at the next available & correct placement
    *
    *@param items the three different items of type String that will be the data keys of the new inserted node
    */
    public void insert(String item, String itemTwo, String itemThree) {
        this.insertCount++;
        if(root == null) {
            root = new BinaryNode(item, itemTwo, itemThree);
        }
        else {
            insert(item, itemTwo, itemThree, root);
        }
    }

    /**
    *inserts a node into the tree at the next available & correct placement
    *
    *@param items the three different items of type String that will be the data keys of the new inserted node
    *@param node the node from which the function will start looking for a placement
    */
    public void insert(String item, String itemTwo, String itemThree, BinaryNode node) {
        this.insertCount++;
        if(item.compareTo(node.dataSet[0]) <= 0) {
            this.insertCount++;
            if(node.left == null) {
                node.left = new BinaryNode(item, itemTwo, itemThree);
            }else {
                insert(item, itemTwo, itemThree, node.left);
            }
        }else {
            this.insertCount++;
            if(node.right == null) {
                node.right = new BinaryNode(item, itemTwo, itemThree);
            }else {
                insert(item, itemTwo, itemThree, node.right);
            }
        }
    }

    /**
    *
    *Finds the node with the given data item, if it exists, passed in as a parameter and returns it
    *@param item the data item passed in to look for
    *@return the node which contains the data item
    */
    public BinaryNode find(String item) {
        if (root == null) {
            return null;
        }else return find(item, root);
    }

    /**
    *
    *Finds the node with the given data item, if it exists, passed in as a parameter and returns it. Traverses through the tree
    *@param item the data item passed in to look for
    *@param node is the current node
    *@return the node which contains the data item
    */
    public BinaryNode find(String item, BinaryNode node) {
        this.count++;
        if(item.compareTo(node.dataSet[0]) == 0) {

            return node;
        }
        this.count++;
        if(item.compareTo(node.dataSet[0]) < 0) {

            return (node.left == null) ?null : find(item, node.left);

        }else {
            return (node.right == null) ?null : find(item, node.right);
        }
    }

    /**
    *prints the data items associated with the given date/time
    *
    *@param dateTime the given date/time to look for in the tree
    */
    public void printDateTime(String dateTime) {
        BinaryNode nodeValues = new BinaryNode();
        nodeValues = find(dateTime);
        if(nodeValues == null) {
            System.out.println("Date/Time not found");
            System.out.println("The operation count was "+(this.insertCount+this.count)+". The find Operation count was "+this.count+" and the insert operation count was "+this.insertCount);
        }else {
            //System.out.println(nodeValues.date);
            System.out.println("The global active number is "+ nodeValues.dataSet[1] + " and the voltage is "+ nodeValues.dataSet[2] + ".");
        }
    }

    /**
    *Traverses through the tree printing the relevant data for each node in the tree
    *
    */
    public void printAllDateTimes() {
        printAllDateTimes(root);
    }

    /**
    *Traverses through the tree printing the relevant data for each node in the tree
    *
    *@param node the current node for whoch the method will print it's data
    *
    */
    public void printAllDateTimes(BinaryNode node) {
        if(root == null) {
            System.out.println("File not found");
            this.count++;
        }else if(node == null){
          System.out.print("");
        }else {
            printAllDateTimes(node.getLeft());
            printAllDateTimes(node.getRight());
            System.out.println(node.dataSet[0]);
            System.out.println("The global active number is "+ node.dataSet[1] + " and the voltage is "+ node.dataSet[2] + ".");
        }
      }
    }
