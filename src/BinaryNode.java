
public class BinaryNode {
	public String[] dataSet = new String[3];
	public BinaryNode left;
	public BinaryNode right;
	public int height;

	public BinaryNode(String date, String voltage, String global) {
		this.dataSet[0] = date;
		this.dataSet[1] = voltage;
		this.dataSet[2] = global;
		left = right = null;
		this.height = 0;
	}

	public BinaryNode() {
		this.dataSet[0] = null;
		this.dataSet[1] = null;
		this.dataSet[2] = null;
		left = right = null;
		this.height = 0;
	}

	/**
	*Get the node on the left of the current node, if it exists otherwise null
	*
	*@return the node to the getLeft*/
	public BinaryNode getLeft() {
		return this.left;
	}

	/**
	*Get the node on the right of the current node, if it exists otherwise null
	*
	*@return the node to the right*/
	public BinaryNode getRight() {
		return this.right;
	}

	/**
	*Returns the voltage data item of the current node
	*
	*@return the voltage of type String
	*/
	public String getVoltage() {
		return this.dataSet[2];
	}

	/**
	*Returns the Gloabal_Active data item of the current node
	*
	*@return the Global_Active of type String
	*/
	public String getGlobal() {
		return this.dataSet[1];
	}

	/**
	*Returns the date data item of the current node
	*
	*@return the date of type String
	*/
	public String getDate() {
		return this.dataSet[0];
	}
}
