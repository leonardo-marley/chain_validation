package org.example;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class CharNode implements Node {
    private char value;
    private Set<Node> dependencies = new HashSet<>();

    public CharNode(char value) {
        this.value = value;
    }

    public CharNode(String value) {
        this.value = value.charAt(0);
        if (value.length() > 1) {
            for (char c : value.toCharArray()) {
                dependencies.add(new CharNode(c));
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
        CharNode charNode = (CharNode) o;
        return value == charNode.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return Character.toString(value);
    }
}
