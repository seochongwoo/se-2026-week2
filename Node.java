import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

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

    // hasChild(), 특정 노드가 자식으로 존재하는지 확인
   public boolean hasChild(Node child) {
        return child != null && this.children.contains(child);
    }
    // 특정 label을 가진 자식이 존재하는지 확인
   public boolean hasChild(String label) {
        for (Node child : this.children) {
            if (child != null && java.util.Objects.equals(child.label, label)) {
                return true;
            }
        }
        return false;
    }

    // height, 트리의 높이 계산
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
    
    // dfs
    public void dfs(){
        Stack<Node> stack=new Stack<>();
        stack.push(this);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.println(current.label);
            for (int i = current.children.size() - 1; i >= 0; i--) {
                Node child = current.children.get(i);
                if (child != null) {
                    stack.push(child);
                }
            }
        }
    }

    // bfs (라벨 순서대로 방문)
    public void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println(current.label);
            for (Node child : current.children) {
                queue.add(child);
            }
        }
    }

}
