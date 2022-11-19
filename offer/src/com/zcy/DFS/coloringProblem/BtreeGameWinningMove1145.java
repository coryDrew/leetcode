package com.zcy.DFS.coloringProblem;

public class BtreeGameWinningMove1145 {
    //智力题，选x的左右子节点或x的父节点是最好的选择
    //选完左子节点，另外两个方向就都不能选了
    //另外两个选法同理
    //胜利条件：三个满足一个即可
    //左子树节点个数>总结点个数-左子树节点个数（即剩余个数）
    //另外两个胜利条件同理
    int leftCnt = 0, rightCnt = 0, total = 0;

    int dfs(TreeNode root, int x) {//dfs计算以root为头的节点个数，太牛逼了，这个x的形参非常妙
        if (root == null) return 0;

        int lv = dfs(root.left, x);
        int rv = dfs(root.right, x);

        if (root.val == x) {//当前遍历到x时，记录它的左右子树的节点个数，赋值给全局变量
            leftCnt = lv;
            rightCnt = rv;
        }
        return lv + rv + 1;
    }

    // 阻断，只有三个节点，就是x节点的父节点，左儿子，右儿子, 最大化
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {

        total = dfs(root, x);//总结点个数

        int pCnt = total - leftCnt  - rightCnt - 1;//父节点所在的部分的节点个数

        if (pCnt > total - pCnt) return true;
        if (leftCnt > total - leftCnt) return true;
        if (rightCnt > total - rightCnt) return true;
        return false;

    }
}
