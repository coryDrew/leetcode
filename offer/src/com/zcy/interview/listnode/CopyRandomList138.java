package com.zcy.interview.listnode;

public class CopyRandomList138 {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        for(Node node = head,copy = null;node != null;node = node.next.next){
            copy = new Node(node.val);
            Node next = node.next;
            node.next = copy;
            copy.next = next;
        }
        for(Node node = head;node != null;node = node.next.next){
            if(node.random != null){
                node.next.random = node.random.next;
            }
        }
        Node newHead = head.next;
        for(Node node = head,temp = null;node!=null&&node.next!= null;){
            temp = node.next;
            node.next = temp.next;
            node = temp;
        }//让所有节点隔着连
        return newHead;
    }
}
