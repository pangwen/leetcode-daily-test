 #938. 二叉搜索树的范围和  
 难度： 简单  
 来源：力扣（LeetCode）  
 链接：https://leetcode-cn.com/problems/range-sum-of-bst/

### 描述：
给定二叉搜索树的根节点 `root`， 返回值位于 `[low, high]` 之间的所有节点值的和。

**示例1**：  
![](https://assets.leetcode.com/uploads/2020/11/05/bst1.jpg)  

**输入**：`root = [10,5,15,3,7,null,18], low = 7, high = 15`  
**输出**：`32`  

**示例2**：  
![](https://assets.leetcode.com/uploads/2020/11/05/bst2.jpg)  

**输入**： `root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10`  
**输出**： `23`

**提示**：

    树中节点数目在范围 [1, 2 * 104] 内
    1 <= Node.val <= 105
    1 <= low <= high <= 105
    所有 Node.val 互不相同


### 题解1
二叉搜索树特性为： 节点值 `left > root > right`。  
通过中序遍历后将节点值存放数组或集合，则集合中的节点值自动***升序***。  
遍历数组/集合， 求数组中 `[low, high]` 范围内的元素和即可。

### 题解2
递归遍历树节点， 当节点值 `node.val > high` 时，递归左子节点。  
当节点值 `node.val < low` 时，递归又节点。  
当节点值满足 `[low, high]` 区间时， 将节点值保存，并同时递归左右节点。


### 更优解题思路
>作者：guanpengchn  
>链接：https://leetcode-cn.com/problems/range-sum-of-bst/solution/hua-jie-suan-fa-938-er-cha-sou-suo-shu-de-fan-wei-/
> - 标签：深度优先遍历  
> - 题意：这个题字面含义很难理解，本意就是求出所有 X >= L 且 X <= R 的值的和
> - 递归终止条件：   
>     - 当前节点为 null 时返回 0
>     - 当前节点 X < L 时则返回右子树之和
>     - 当前节点 X > R 时则返回左子树之和
>     - 当前节点 X >= L 且 X <= R 时则返回：当前节点值 + 左子树之和 + 右子树之和
> - 注意点：通过判断X的大小能够避免遍历全部树的节点，比如下方的动图中，3 这个值就没有必要遍历  
> 
>**图解**：  
![](https://pic.leetcode-cn.com/f553e350feac9022d49af24b6ddf20f6bacea42f8fb0ba42d174b0bd0a295fd0-frame_00001.png)
 

