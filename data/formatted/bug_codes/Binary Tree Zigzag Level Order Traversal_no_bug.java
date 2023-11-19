class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        q.offer(root);
        boolean flag = true;
        while (! q.isEmpty()) {
            int size = q.size();
            List<Integer> curr = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (q.peek().left != null) {
                    q.offer(q.peek().left);
                }
                if (q.peek().right != null) {
                    q.offer(q.peek().right);
                }
                if (flag == true) {
                    curr.add(q.poll().val);
                } else {
                    curr.add(0, q.poll().val);
                }
            }
            if (flag == true) {
                flag = false;
            } else {
                flag = true;
            }
            res.add(curr);
        }
        return res;
    }
}
