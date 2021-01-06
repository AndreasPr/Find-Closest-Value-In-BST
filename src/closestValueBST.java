/**
 * Created on 05/Jan/2021 to FindClosestValueInBST
 */
public class closestValueBST {

    static class Node{
        int data;
        Node left;
        Node right;
    }

    static Node newNode(int data){
        Node temp = new Node();
        temp.data = data;
        temp.left = temp.right = null;
        return temp;
    }

    static Node findTheClosestValue(Node root, int key){
        int diff = Integer.MAX_VALUE;
        Node curr = root;
        Node closest = null;

        while(curr != null){

            if(curr.left == null){
                //update diff if the current diff is smaller than prev difference
                if(diff > Math.abs(curr.data - key)){
                    diff = Math.abs(curr.data - key);
                    closest = curr;
                }
                curr = curr.right;
            }
            else{
                Node pre = curr.left;
                while(pre.right != null && pre.right != curr){
                    pre = pre.right;

                }

                if(pre.right == null){
                    pre.right = curr;
                    curr = curr.left;

                }
                else{
                    pre.right = null;
                    if(diff > Math.abs(curr.data - key)){
                        diff = Math.abs(curr.data - key);
                        closest = curr;
                    }
                    //move to the right child
                    curr = curr.right;
                }
            }
        }

        return closest;
    }

    public static void main(String[] args){
        Node root = newNode(5);
        root.left = newNode(3);
        root.right = newNode(9);
        root.left.left = newNode(1);
        root.left.right = newNode(2);
        root.right.left = newNode(8);
        root.right.right = newNode(12);

        System.out.println(findTheClosestValue(root, 10).data);
    }


}
