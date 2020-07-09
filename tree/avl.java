import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
public class avl{

    public static void main(String[] args){
        int[] arr={70,40,20,10,-1,-1,30,25,22,-1,-1,-1,-1,60,50,-1,-1,-1,100,80,-1,90,-1,-1,120,110,-1,-1,-1};
         Node root=construct(arr);
         System.out.println(getbalance(root));
        display(root);
        root=addnode(root,55);
        root=updatefactor(root);
         System.out.println();
        System.out.println(getbalance(root));
        display(root);
        root=deletenode(root,55);
        root=updatefactor(root);
         System.out.println();
        System.out.println(getbalance(root));
        display(root);


    }
    

     public static class Node{
        private int data=0;
        private Node left=null;
        private Node right=null;

        Node(){

        }

        Node(int data){
            this.data=data;
        }

        Node(int data,Node left,Node right){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }

    static int idx=0;
    public static Node construct(int[] arr){
       if(idx>=arr.length || arr[idx]==-1){
          idx++;
           return null;
       }

       Node node=new Node(arr[idx]);
       idx++;
       node.left=construct(arr);
       node.right=construct(arr);
       node=updatefactor(node);
       return node;
    }

    public static void display(Node node){
        if(node==null)
         return ;
        
        StringBuilder sb=new StringBuilder();
        sb.append(node.left!=null?node.left.data:".");
        sb.append("->"+node.data+"<-");
        sb.append(node.right!=null?node.right.data:".");
        System.out.println(sb.toString());
        display(node.left);
        display(node.right);         
    }

   public static int size(Node node){
       if(node==null)return 0;
       return size(node.left)+size(node.right)+1;
   }

   public static int height(Node node){
       if(node==null)return 0;
       return Math.max(height(node.left),height(node.right))+1;
   }


   public static int getbalance(Node node){
       if(node==null)return 0;
         return height(node.left)-height(node.right);
   }

   public static Node leftrotation(Node node){
       if(node==null)return null;

       Node n=new Node();
       n=node.right;
       Node t=new Node();
       t=n.left;
       n.left=node;
       node.right=t;
       node=updatefactor(node);
       n=updatefactor(n);
       return n;
   }

    public static Node rightrotation(Node node){
       if(node==null)return null;

       Node n=new Node();
       n=node.left;
       Node t=new Node();
       t=n.right;
       n.right=node;
       node.left=t;
       node=updatefactor(node);
       n=updatefactor(n);
       return n;
   }


   public static Node updatefactor(Node node){
       if(getbalance(node)>1){
           if(getbalance(node.left)>0)
             node=rightrotation(node);
            else{
                node.left=leftrotation(node.left);
                node=rightrotation(node);
            } 
       }
       else if(getbalance(node)<-1){
           if(getbalance(node.right)<0)
             node=leftrotation(node);
           else{
               node.right=rightrotation(node.right);
               node=leftrotation(node);
           }
       }

       return node;
   }


   public static Node addnode(Node node,int data){
       if(node==null){
           node=new Node(data);
           return node;
       }
       
       if(data<=node.data)
        node.left=addnode(node.left,data);
        else if(data>node.data)
         node.right=addnode(node.right,data);

        return node;
   }

   public static Node deletenode(Node node,int data){
       if(node==null)return null;
       else if(node.data==data){
           if(node.left==null && node.right==null)
            return null;
           else if((node.left!=null && node.right==null) || (node.right!=null && node.left==null)){
            if(node.left!=null){
            node.data=node.left.data;
            node.left=null;
           }
            else if(node.right!=null){
            node.data=node.right.data;
            node.right=null;
           }
           }
           else{
            int d=leftmax(node.left);
            node.data=d;
           }
       return node;
       }

       if(node.data>data)
        node.right=deletenode(node.right,data);
        else 
        node.left=deletenode(node.left,data);

        return node;
   }

    

  // delete node with both child

  public static int leftmax(Node node){
    if(node.right==null){
      int temp=node.data;
      if(node.left!=null){
       node=node.left;
       node.left=null;
      }
       else
       node=null;
       return temp;
    }
    else if(node.right.right==null){
      int temp=node.right.data;
      if(node.right.left!=null){
        node.right=node.right.left;
      }
      else 
       node.right=null;
       return temp;
    }

    return leftmax(node.right);
  }

  
}