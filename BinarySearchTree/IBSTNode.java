package uppg2_BinarySearchTree;

/**
 * An IBSTNode defines a binary tree node containing references to the node's
 * parent, left and right child nodes as well as an element stored in the node.
 * @param <E> the type of elements stored at the nodes in this tree
 * @author H�kan Mattsson
 */
interface IBSTNode<E extends Comparable<E>> {

	/**
	 * Replace the element currently associated with this tree node, with the
	 * specified element.
   * Returns the previous element associated with this tree node. <br/><br/>
   * <strong>Note!</strong> Updating the element erroneously may violate the
   * property that should hold for elements in a binary search tree.
   * @param element the element to be associated with this tree node
   * @return the previous element associated with this tree node
	 */
	public E setElement(E element);

  /**
   * Returns the element of this tree node.
   * @return the element of this tree node
   */
  public E getElement();
  
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
  public int compareTo(IBSTNode<E> bstNode) throws NullPointerException;

  /**
   * Replace the parent node currently associated with this tree node,
   * with the specified tree node.
   * @param parent the node to be associated with this tree node
   */
  public void setParent(IBSTNode<E> parent);

  /**
   * Returns the parent node currently associated with this tree node.	
   * @return the parent node currently associated with this tree node
   */
	public IBSTNode<E> getParent();

  /**
   * Returns true if this tree node has a parent node, else false.
   * @return true if this tree node has a parent node, else false
   */
  public boolean hasParent();

  /**
   * Replace the left child node currently associated with this tree node,
   * with the specified tree node.
   * @param left the node to be associated with this tree node
   */
	public void setLeftChild(IBSTNode<E> left);

	/**
	 * Returns the left child node currently associated with this tree node.
	 * @return the left child node currently associated with this tree node
	 */
	public IBSTNode<E> getLeftChild();

  /**
   * Returns true if this tree node has a left child node, else false.
   * @return true if this tree node has a left child node, else false
   */
  public boolean hasLeftChild();

  /**
   * Replace the right child node currently associated with this tree node,
   * with the specified tree node.
   * @param right the node to be associated with this tree node
   */
  public void setRightChild(IBSTNode<E> right);
  
	/**
	 * Returns the right child node currently associated with this tree node.
	 * @return the right child node currently associated with this tree node
	 */
	public IBSTNode<E> getRightChild();

  /**
   * Returns true if this tree node has a right child node, else false.
   * @return true if this tree node has a right child node, else false
   */
  public boolean hasRightChild();

  /**
   * Returns true if this tree node is the root node, else false.
   * @return true if this tree node is the root node, else false
   */
  public boolean isRoot();

  /**
   * Returns true if this tree node is a left child node, else false.
   * @return true if this tree node is a left child node, else false
   */
  public boolean isLeftChild();

  /**
   * Returns true if this tree node is a right child node, else false.
   * @return true if this tree node is a right child, else false
   */
  public boolean isRightChild();

  /**
   * Returns true if this tree node is an internal node, else false.
   * @return true if this tree node is an internal node, else false
   */
  public boolean isInternal();

  /**
   * Returns true if this tree node is an external node, else false.
   * @return true if this tree node is an external node, else false
   */
  public boolean isExternal();
  
  /**
   * Returns a string representation of the element stored at this tree node,
   * or the empty string ("") if the element equals null
   * Note that E may have to implement the toString() method.
   * @return a string representation of the element stored at this tree node,
   *         or the empty string ("") if the element equals null
   */
  @Override
  public String toString();
}