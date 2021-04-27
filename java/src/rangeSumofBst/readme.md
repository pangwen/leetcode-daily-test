 #938. 二叉搜索树的范围和  

### 描述：
给定二叉搜索树的根节点 `root`， 返回值位于 `[low, high]` 之间的所有节点值的和。

**示例1**：  
![](https://assets.leetcode.com/uploads/2020/11/05/bst1.jpg)  

**输入**：`root = [10,5,15,3,7,null,18], low = 7, high = 15`  
**输出**： `32`  

**示例2**：  
![](https://assets.leetcode.com/uploads/2020/11/05/bst2.jpg)  

**输入**： `root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10`  
**输出**： `23`

**提示**：

    树中节点数目在范围 [1, 2 * 104] 内
    1 <= Node.val <= 105
    1 <= low <= high <= 105
    所有 Node.val 互不相同
