package uppg2_BinarySearchTree;

import java.util.ArrayList;

/**
 * An implementation of the interface IBSTNode<E>.
 *
 * @param <E> the type of elements stored at the nodes in this tree
 * @author Henrik Eliasson
 */
public class BST<E extends Comparable<E>> implements IBST<E> {

        private IBSTNode<E> _Root;
        private int _Size;

        @Override
        public ArrayList<E> BFS(IBSTNode<E> bstNode) throws NullPointerException {
                if (bstNode == null) {
                        throw new NullPointerException();
                }
                else if (_Size == 0) {
                        return null;
                }
                ArrayList<E> list = new ArrayList<>();
                return internalBFS(bstNode, list);
        }

        /**
         * Executes a breadth first search on a binary tree
         */
        private ArrayList<E> internalBFS(IBSTNode<E> bstNode, ArrayList<E> list) {
                ArrayList<IBSTNode<E>> level = new ArrayList<>();
                level.add(bstNode);
                while (!level.isEmpty()) {
                        ArrayList<IBSTNode<E>> nextLevel = new ArrayList<>();
                        for (IBSTNode<E> node : level) {
                                if (node.hasLeftChild()) {
                                        nextLevel.add(node.getLeftChild());
                                }
                                if (node.hasRightChild()) {
                                        nextLevel.add(node.getRightChild());
                                }
                                list.add(node.getElement());
                        }
                        level = nextLevel;
                }
                return list;
        }

        @Override
        public void clear() {
                _Root = null;
                _Size = 0;
        }

        @Override
        public E get(E element) throws NullPointerException {
                if (element.equals(null)) {
                        throw new NullPointerException();
                }
                else if (_Size == 0) {
                        return null;
                }
                else if (_Root.getElement() == element) {
                        return _Root.getElement();
                }
                else {
                        try {
                                return (E) getNode(element).getElement();
                        }
                        catch (NullPointerException e) {
                                return null;
                        }
                }
        }

        @Override
        public ArrayList<E> inOrder(IBSTNode<E> bstNode) throws NullPointerException {
                if (bstNode == null) {
                        throw new NullPointerException();
                }
                else if (_Size == 0) {
                        return null;
                }
                ArrayList<E> list = new ArrayList<>();
                return internalInOrder(bstNode, list);

        }

        /**
         * Executes a in order search on a binary tree.
         *
         * @param bstNode The node to use as root.
         * @param list The arraylist to store the order of elements.
         * @return Returns the elements of this tree as an arraylist sorted with
         * inOrder.
         */
        private ArrayList<E> internalInOrder(IBSTNode bstNode, ArrayList<E> list) {
                if (bstNode.hasLeftChild()) {
                        internalInOrder(bstNode.getLeftChild(), list);
                }
                list.add((E) bstNode.getElement());
                if (bstNode.hasRightChild()) {
                        internalInOrder(bstNode.getRightChild(), list);
                }
                return list;
        }

        @Override
        public boolean isEmpty() {
                if (_Size == 0) {
                        return true;
                }
                return false;
        }

        @Override
        public ArrayList<E> postOrder(IBSTNode<E> bstNode) throws NullPointerException {
                if (bstNode == null) {
                        throw new NullPointerException();
                }
                else if (_Size == 0) {
                        return null;
                }
                ArrayList<E> list = new ArrayList<>();
                return internalPostOrder(bstNode, list);

        }

        /**
         * Executes a post order search on a binary tree
         *
         * @param bstNode The node to use as root.
         * @param list The arraylist to store the order of elements.
         * @return Returns the elements of this tree as an arraylist sorted with
         * postOrder.
         */
        private ArrayList<E> internalPostOrder(IBSTNode bstNode, ArrayList<E> list) {
                if (bstNode.hasLeftChild()) {
                        internalPostOrder(bstNode.getLeftChild(), list);
                }
                if (bstNode.hasRightChild()) {
                        internalPostOrder(bstNode.getRightChild(), list);
                }
                list.add((E) bstNode.getElement());
                return list;
        }

        @Override
        public ArrayList<E> preOrder(IBSTNode<E> bstNode) throws NullPointerException {
                if (bstNode == null) {
                        throw new NullPointerException();
                }
                else if (_Size == 0) {
                        return null;
                }
                ArrayList<E> list = new ArrayList<>();
                return internalPreOrder(bstNode, list);
        }

        /**
         * Executes a pre order search on a binary tree
         *
         * @param bstNode The node to use as root.
         * @param list The arraylist to store the order of elements.
         * @return Returns the elements of this tree as an arraylist sorted with
         * preOrder.
         */
        private ArrayList<E> internalPreOrder(IBSTNode bstNode, ArrayList<E> list) {
                list.add((E) bstNode.getElement());
                if (bstNode.hasLeftChild()) {
                        internalPreOrder(bstNode.getLeftChild(), list);
                }
                if (bstNode.hasRightChild()) {
                        internalPreOrder(bstNode.getRightChild(), list);
                }
                return list;
        }

        @Override
        public E put(E element) throws ClassCastException, NullPointerException {
                if (element == null) {
                        throw new NullPointerException();
                }
                IBSTNode<E> newNode = new BSTNode(element);
                if (_Size == 0) {
                        _Root = newNode;
                        _Size++;
                        return element;
                }

                IBSTNode<E> temp = _Root;
                while (true) {
                        if (element.compareTo(temp.getElement()) < 0) {
                                if (temp.hasLeftChild()) {
                                        temp = temp.getLeftChild();
                                }
                                else {
                                        temp.setLeftChild(newNode);
                                        newNode.setParent(temp);
                                        _Size++;
                                        return element;
                                }
                        }
                        else if (element.compareTo(temp.getElement()) > 0) {
                                if (temp.hasRightChild()) {
                                        temp = temp.getRightChild();
                                }
                                else {
                                        temp.setRightChild(newNode);
                                        newNode.setParent(temp);
                                        _Size++;
                                        return element;
                                }
                        }
                        else {
                                return null;
                        }
                }
        }

        @Override
        public E remove(E element) throws NullPointerException {
                if (element == null) {
                        throw new NullPointerException();
                }
                else if (_Size == 0 || getNode(element) == null) {
                        return null;
                }
                else if (_Size == 1 && element.equals(_Root.getElement())) {
                        clear();
                        return element;
                }
                IBSTNode temp = getNode(element);
                IBSTNode parent = temp.getParent();
                if (!temp.hasLeftChild() && !temp.hasRightChild()) { //When the node to remove has no children
                        removeNone(temp, parent);
                }
                else if ((temp.hasLeftChild() && !temp.hasRightChild())
                        || (temp.hasRightChild() && !temp.hasLeftChild())) { //When the node to remove has a single child
                        removeSingle(temp, parent);
                }
                else {
                        removeDouble(temp);
                }
                return element;
        }

        /**
         * Removal of a node with no children.
         *
         * @param temp The node to remove.
         * @param parent The parent node to temp.
         */
        private void removeNone(IBSTNode<E> temp, IBSTNode parent) {
                if (parent.hasLeftChild() && parent.getLeftChild().getElement().equals(temp.getElement())) { //Are we our parents left child?
                        parent.setLeftChild(null);
                }
                else { //Or right child?
                        parent.setRightChild(null);
                }
                _Size--;
        }

        /**
         * Removal of a node with a single child.
         *
         * @param temp The node to remove.
         * @param parent The parent node to temp.
         */
        private void removeSingle(IBSTNode<E> temp, IBSTNode parent) {
                if (temp.hasLeftChild()) {
                        if (temp.getLeftChild().compareTo(parent) < 0) { //Are we lesser than our parent?
                                parent.setLeftChild(temp.getLeftChild());
                                temp.getLeftChild().setParent(parent);
                        }
                        else { //or greater than our parent?
                                parent.setRightChild(temp.getLeftChild());
                                temp.getLeftChild().setParent(parent);
                        }
                }
                else {
                        if (temp.getRightChild().compareTo(parent) < 0) { //Are we lesser than our parent?
                                parent.setLeftChild(temp.getRightChild());
                                temp.getRightChild().setParent(parent);
                        }
                        else { //or greater than our parent?
                                parent.setRightChild(temp.getRightChild());
                                temp.getRightChild().setParent(parent);
                        }
                }
                _Size--;
        }

        /**
         * Removal of a node with two children.
         *
         * @param temp The node to remove.
         */
        private void removeDouble(IBSTNode<E> temp) {
                IBSTNode<E> newNode = minValue(temp.getRightChild()); //Leta oss ner till det närmsta värdet högre än vad temp har.
                temp.setElement(newNode.getElement());
                if (newNode.hasRightChild()) { //Om detta lägsta värde har högerbarn, så flytta upp dem.
                        newNode.setElement(newNode.getRightChild().getElement());
                        newNode.setRightChild(newNode.getRightChild().getRightChild());
                }
                else {
                        if (!temp.getRightChild().isExternal()) { //Radera bara parent.getLeftChild om vi har loopat ner åt vänster.
                                newNode.getParent().setLeftChild(null);
                        }
                        else { //Annars är newNode.getParent() == temp och då måste vi radera högernoden istället.
                                temp.setRightChild(null);
                        }
                }
                _Size--;
        }

        @Override
        public IBSTNode<E> root() {
                if (_Size != 0) {
                        return _Root;
                }
                return null;
        }

        @Override
        public int size() {
                return _Size;
        }

        @Override
        public String toString() {
                if (_Size == 0) {
                        return "[]";
                }
                StringBuilder sb = new StringBuilder();
                ArrayList<E> list = inOrder(_Root);
                sb.append("[");
                for (E element : list) {
                        sb.append(element + ", ");;
                }
                sb.delete(sb.lastIndexOf(", "), sb.length());
                sb.append("]");
                return sb.toString();
        }

        /**
         * Returns the node containing the requested element. Returns null when
         * the element does not exist.
         *
         * @param element The element to look for in this tree.
         * @return The IBSTNode containing the requested element.
         */
        private IBSTNode getNode(E element) {
                IBSTNode<E> temp = _Root;
                while (true) {
                        if (element.compareTo(temp.getElement()) < 0) {
                                if (temp.hasLeftChild()) {
                                        temp = temp.getLeftChild();
                                }
                                else {
                                        return null;
                                }
                        }
                        else if (element.compareTo(temp.getElement()) > 0) {
                                if (temp.hasRightChild()) {
                                        temp = temp.getRightChild();
                                }
                                else {
                                        return null;
                                }
                        }
                        else if (element.compareTo(temp.getElement()) == 0) {
                                return temp;
                        }
                }
        }

        /**
         * Returns the leftmost node in a given tree.
         *
         * @param node The tree to iterate through.
         * @return Returns the IBSTNode containing the lowest value in this
         * tree.
         */
        private IBSTNode minValue(IBSTNode node) {
                if (node.hasLeftChild()) {
                        return minValue(node.getLeftChild());
                }
                else {
                        return node;
                }
        }
}
