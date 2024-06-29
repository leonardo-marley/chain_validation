package org.example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChainValidator {
    public boolean validate(List<Node> nodes) {
        Set<Node> singleNodes = new HashSet<>();
        for (Node node : nodes) {
            if (node.getDependencies().isEmpty()) {
                singleNodes.add(node);
            }
        }
        for (Node node : nodes) {
            if (!node.getDependencies().isEmpty() && !node.isValid(singleNodes)) {
                return false;
            }
        }
        return true;
    }
}
