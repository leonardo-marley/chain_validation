package org.example;

import java.util.Set;

interface Node {
    Set<Node> getDependencies();
    boolean isValid(Set<Node> singleNodes);
}
