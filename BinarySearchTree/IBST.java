package uppg2_BinarySearchTree;

import java.util.ArrayList;

/**
 * A binary search tree (BST) is a binary tree T such that each node N of T
 * stores an element e where: <br />
 * - elements stored at nodes in the left subtree of N are &le; e. <br />
 * - elements stored at nodes in the right subtree of N are &gt; e. <br />
 * The implementation of this BST assumes no duplicate elements; each element
 * can be inserted only once. Also, it is assumed that this BST is unbalanced.
 * <br /><br />
 * 
 * In the case of duplicate values for a specific element, we could use an
 * auxiliary data structure at a node, e.g. a linked list, to store all
 * values corresponding to that specific element. <br /><br />
 *
 * All elements inserted into the BST <strong>must</strong> implement the
 * Comparable interface. Furthermore, all such elements must be <it>mutually
 * comparable</it> (i.e. comparison is a total relation):
 * <tt>e1.compareTo(e2)</tt> must <strong>not</strong> throw a
 * <tt>ClassCastException</tt> for any elements <tt>k1</tt> and <tt>k2</tt> in
 * the BST. If the user attempts to put an element into the tree that violates
 * this constraint (for example, the user attempts to put a String element into
 * a BST whose elements are Integers), the <tt>put(E element)</tt> call will
 * throw a <tt>ClassCastException</tt>.
 * @author H�kan Mattsson
 * @param <E> the type of elements stored at the nodes in this tree
 */
public interface IBST<E extends Comparable<E>> {

	/**
	 * Returns an ArrayList of elements stored at the tree nodes when performing
	 * a breadth first search, starting at the specified node, or null if this
	 * tree is empty. The ArrayList will contain the element of the specified
	 * node followed by the elements of all its descendants ordered from the
	 * leftmost to the rightmost child.
	 * @param bstNode the node from which the breadth first search will start
	 * @return an ArrayList of elements stored at the tree nodes when performing
	 *         a breadth first search, starting at the specified node, or null if
	 *         this tree is empty
	 * @throws NullPointerException if the specified tree node equals null
	 */
	public ArrayList<E> BFS(IBSTNode<E> bstNode) throws NullPointerException;

	/**
	 * Removes all of the nodes in this tree.
	 */
	public void clear();

	/**
	 * Returns the specified element if it was found in this tree, or null if the
	 * element was not found in this tree or this tree is empty.
	 * @param element the element to be returned
	 * @return the specified element if it was found in this tree, or null if the
	 *         element was not found in this tree or this tree is empty
	 * @throws NullPointerException if the specified element equals null
	 */
	public E get(E element)	throws NullPointerException;

	/**
	 * Returns an ArrayList of elements when performing an inorder traversal
	 * starting at the specified node, or null if this tree is empty.
	 * @param bstNode the node from which an inorder traversal will start
	 * @return an ArrayList of elements when performing an inorder traversal
	 *         starting at the specified node, or null if this tree is empty
	 * @throws NullPointerException if the specified tree node equals null
	 */
	public ArrayList<E> inOrder(IBSTNode<E> bstNode) throws NullPointerException;

	/**
	 * Returns true if this tree is empty, else false.
	 * @return true if this tree is empty, else false
	 */
	public boolean isEmpty();

	/**
	 * Returns an ArrayList of elements when performing a postorder traversal
	 * starting at the specified node, or null if this tree is empty.
	 * @param bstNode the node from which a postorder traversal will start
	 * @return an ArrayList of elements when performing a postorder traversal
	 *         starting at the specified node, or null if this tree is empty
	 * @throws NullPointerException if the specified tree node equals null
	 */
	public ArrayList<E> postOrder(IBSTNode<E> bstNode) throws NullPointerException;

	/**
	 * Returns an ArrayList of elements when performing a preorder traversal
	 * starting at the specified node, or null if this tree is empty.
	 * @param bstNode the node from which a preorder traversal will start
	 * @return an ArrayList of elements when performing a preorder traversal
	 *         starting at the specified node, or null if this tree is empty
	 * @throws NullPointerException if the specified tree node equals null
	 */
	public ArrayList<E> preOrder(IBSTNode<E> bstNode) throws NullPointerException;

	/**
	 * Inserts the specified element into this tree. If the tree already contains
	 * this element the insertion is simply ignored since no duplicates are
	 * allowed.
	 * Returns null if the element was previously inserted, or the element if no
	 * previous occurrence of the element was found in this tree.
	 * @param element the element to be inserted into this tree
	 * @return null if the element was previously inserted, or the element if no
	 *         previous occurrence of the element was found in this tree
	 * @throws ClassCastException if the specified element cannot be compared
	 *         with elements currently in this tree
	 * @throws NullPointerException if the specified element equals null 
	 */
	public E put(E element)	throws ClassCastException, NullPointerException;

	/**
	 * Removes the specified element from this tree.
	 * Returns the specified element if it was found in this tree, or null if the
	 * element was not found in this tree or this tree is empty.
	 * @param element the element to be removed from this tree
	 * @return the element if it was found in this tree or null if the element
	 *         was not found in this tree
	 * @throws NullPointerException if the specified element equals null
	 */
	public E remove(E element) throws NullPointerException;

	/**
	 * Returns the root node or null if this tree is empty. 
	 * @return the root node or null if this tree is empty
	 */
	public IBSTNode<E> root();

	/**
	 * Returns the number of nodes in this tree.
	 * @return the number of nodes in this tree
	 */
	public int size();

	/**
	 * Returns a string representation of this tree. The string representation
	 * consists of the elements of the tree nodes when performing an inorder
	 * traversal starting at the root node, enclosed in square brackets ("[]").
	 * Adjacent elements are separated by the characters ", " (comma and space).
	 * Note that E may have to implement the toString() method.
	 * @return a string representation of this tree
	 */
	@Override
	public String toString();
}