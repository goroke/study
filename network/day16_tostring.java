// import Node.*;
public class day16_tostring {
    // "psvm"/"main" 치면 자동완성 가능
    public static void main(String args[]){
        Node node = new Node(); Node pre = node; Node head = node;
        node.data = "피카츄";
        System.out.println(node);   // "sout" 치면 자동완성 가능

        for(int i=0; i<=10; i++){
            pre.link = node;
            node.data = Integer.toString(i);
            pre = node;
            node = new Node();
        }
        System.out.println(head.link.link.link.link.data);
    }
}
