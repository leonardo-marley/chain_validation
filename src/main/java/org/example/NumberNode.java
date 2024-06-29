package org.example;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class NumberNode implements Node {
    private int value;
    private Set<Node> dependencies = new HashSet<>();

    public NumberNode(int value) {
        this.value = value;
        if (value > 9) {
            String str = Integer.toString(value);
            for (char c : str.toCharArray()) {
                dependencies.add(new NumberNode(Character.getNumericValue(c)));
            }
        }
    }

    @Override
    public Set<Node> getDependencies() {
        return dependencies;
    }

    @Override
    public boolean isValid(Set<Node> singleNodes) {
        return singleNodes.containsAll(dependencies);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberNode that = (NumberNode) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
