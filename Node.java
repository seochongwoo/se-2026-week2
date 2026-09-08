import java.util.ArrayList;
import java.util.List;

public class Node {
    public String label;
    public Node parent;
    public List<Node> children;

    public Node(String label) {
        this.label = label;
        this.children = new ArrayList<>();
    }

    public void addChild(Node child) {
        this.children.add(child);
    }

   public boolean hasChild(Node child) {
        return child != null && this.children.contains(child);
    }

   public boolean hasChild(String label) {
        for (Node child : this.children) {
            if (child != null && java.util.Objects.equals(child.label, label)) {
                return true;
            }
        }
        return false;
    }

    public int height() {
        // 리프 노드의 높이는 0으로 처리
        int height = 0;
        for (Node child : this.children) {
            if (child != null) {
                height = Math.max(height, child.height() + 1);
            }
        }
        return height;
    }
}
