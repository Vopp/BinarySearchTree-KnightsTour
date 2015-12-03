package uppg2_BinarySearchTree;

/**
 * An implementation of the interface IBSTNode<E>.
 * @param <E> the type of elements stored at the nodes in this tree
 * @author H�kan Mattsson
 */
final class BSTNode<E extends Comparable<E>> implements IBSTNode<E> {

	// The element stored at this node
	private E mElement;
	// The parent node of this tree node
	private IBSTNode<E> mParent;
	// The left child node of this tree node
	private IBSTNode<E> mLeft;
	// The right child node of this tree node
	private IBSTNode<E> mRight;

	/**
	 * Constructs a tree node containing an element and no references to parent
	 * or child nodes.
	 * @param key the key stored at this tree node
	 * @param value the value stored at this tree node
	 */
	public BSTNode(E element) {

		this(element, null, null, null);
	}

	/**
	 * Constructs a tree node containing an element and references to parent,
	 * left and right as its parent and child nodes. 
	 * @param element the element stored at this tree node
	 * @param parent the parent node of this tree node
	 * @param left the left child node of this tree node
	 * @param right the right child node of this tree node
	 */
	public BSTNode(E element, IBSTNode<E> parent, IBSTNode<E> left, IBSTNode<E> right) {

    // Initialize member variables
		mElement = element;
		mParent = parent;
		mLeft = left;
		mRight = right;
	}

	/**
	 * Replace the element currently associated with this tree node, with the
	 * specified element.
   * Returns the previous element associated with this tree node. <br/><br/>
   * <strong>Note!</strong> Updating the element erroneously may violate the
   * property that should hold for elements in a binary search tree.
   * @param element the element to be associated with this tree node
   * @return the previous element associated with this tree node
	 */
	public E setElement(E element) {

		E tempElement = mElement;
		mElement = element;
		return tempElement;
	}

  /**
   * Returns the element of this tree node.
   * @return the element of this tree node
   */
	public E getElement() {

		return mElement;
	}

  /**
   * Compares this tree node with the specified tree node for order. Returns
   * a negative integer, zero, or a positive integer as this tree node's
   * element is less than, equal to, or greater than the specified tree node's
   * element.
   * @param bstNode the tree node whose element is to be compared.
   * @return a negative integer, zero, or a positive integer as this tree
   *         node's element is less than, equal to, or greater than the
   *         specified tree node's element.
   * @throws NullPointerException if the specified tree node equals null
   */
	public int compareTo(IBSTNode<E> bstNode)	throws NullPointerException {

		checkTreeNodeForNull(bstNode);

		return this.getElement().compareTo(bstNode.getElement());
	}

  /**
   * Replace the parent node currently associated with this tree node,
   * with the specified tree node.
   * @param parent the node to be associated with this tree node
   */
	public void setParent(IBSTNode<E> parent) {

		mParent = parent;
	}

  /**
   * Returns the parent node currently associated with this tree node.	
   * @return the parent node currently associated with this tree node
   */
	public IBSTNode<E> getParent() {

		return mParent;
	}

  /**
   * Returns true if this tree node has a parent node, else false.
   * @return true if this tree node has a parent node, else false
   */
	public boolean hasParent() {

		return (mParent != null ? true : false);
	}

  /**
   * Replace the left child node currently associated with this tree node,
   * with the specified tree node.
   * @param left the node to be associated with this tree node
   */
	public void setLeftChild(IBSTNode<E> left) {

		mLeft = left;
	}

	/**
	 * Returns the left child node currently associated with this tree node.
	 * @return the left child node currently associated with this tree node
	 */
	public IBSTNode<E> getLeftChild() {

		return mLeft;
	}

  /**
   * Returns true if this tree node has a left child node, else false.
   * @return true if this tree node has a left child node, else false
   */
	public boolean hasLeftChild() {

		return (mLeft != null ? true : false);
	}

  /**
   * Replace the right child node currently associated with this tree node,
   * with the specified tree node.
   * @param right the node to be associated with this tree node
   */
	public void setRightChild(IBSTNode<E> right) {

		mRight = right;
	}

	/**
	 * Returns the right child node currently associated with this tree node.
	 * @return the right child node currently associated with this tree node
	 */
	public IBSTNode<E> getRightChild() {

		return mRight;
	}

  /**
   * Returns true if this tree node has a right child node, else false.
   * @return true if this tree node has a right child node, else false
   */
	public boolean hasRightChild() {

		return (mRight != null ? true : false);
	}

  /**
   * Returns true if this tree node is the root node, else false.
   * @return true if this tree node is the root node, else false
   */
	public boolean isRoot() {

		return (mParent == null ? true : false);
	}

  /**
   * Returns true if this tree node is a left child node, else false.
   * @return true if this tree node is a left child node, else false
   */
	public boolean isLeftChild() {

		if (!isRoot() && mParent.getLeftChild() == this) {
			return true;
		}
		else {
			return false;
		}
	}

  /**
   * Returns true if this tree node is a right child node, else false.
   * @return true if this tree node is a right child, else false
   */
	public boolean isRightChild() {

		return (!isLeftChild());
	}

  /**
   * Returns true if this tree node is an internal node, else false.
   * @return true if this tree node is an internal node, else false
   */
	public boolean isInternal() {

		return (mLeft != null || mRight != null);
	}

  /**
   * Returns true if this tree node is an external node, else false.
   * @return true if this tree node is an external node, else false
   */
	public boolean isExternal() {

		return (!isInternal());
	}

  /**
   * Returns a string representation of the element stored at this tree node,
   * or the empty string ("") if the element equals null
   * Note that E may have to implement the toString() method.
   * @return a string representation of the element stored at this tree node,
   *         or the empty string ("") if the element equals null
   */
  @Override
	public String toString() {

  	if (mElement == null) {
  		return "";
  	}
  	else {
  		return mElement.toString();
  	}
	}
  
  /**
   * Check whether the specified tree node is null or not.
   * @param bstNode the tree node that should be checked for null
	 * @throws NullPointerException if the specified tree node equals null 
   */
  private void checkTreeNodeForNull(IBSTNode<E> bstNode) throws NullPointerException {

  	// If bstNode is null throw a NullPointerException
		if (bstNode == null) {
			throw new NullPointerException("checkTreeNodeForNull: bstNode = " + bstNode);
		}
  }
}