package com.zcy.offertwo;

public class Insert029 {
    //找到合适的位置插入新元素，返回头节点
    public Node insert(Node head, int insertVal) {
        if (head==null){
            Node node = new Node(insertVal);
            node.next=node;
            return node;
        }
        Node cur = head;
        while(cur.next!=head){
            if (cur.next.val<cur.val){
                if (cur.next.val>=insertVal){
                    //最小值
                    //[3,5,1] 0 ==> [3,5,0,1]
                    break;
                }else if (cur.val<=insertVal){
                    //最大值
                    //[3,5,1] 6 ==>[3,5,6,1]
                    break;
                }
            }
            //中间顺序插入
            //[1,3,5] 2 ==> [1,2,3,5]
            if (cur.val<=insertVal&&cur.next.val>=insertVal){
                break;
            }
            //移动指针
            cur=cur.next;
        }
        //插入新节点
        cur.next=new Node(insertVal,cur.next);
        return head;
    }
}
