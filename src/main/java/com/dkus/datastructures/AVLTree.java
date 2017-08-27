package com.dkus.datastructures;

public class AVLTree<V> extends BinarySearchTree<V> {

    /**
     *
     * The AVL tree implements the usual insertion but adds rebalancing as well.
     *
     * @param key
     * @param value
     * @return
     * @throws Exception
     */
    @Override
    BinaryNode<V> put(int key, V value) throws Exception {
        return super.put(key, value);
    }

    // TODO: Node needs to store balancing factor too
}

