import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
public class binarytree{

    public static void main(String[] args){
        int[] arr={70,40,20,10,-1,-1,30,-1,-1,60,50,-1,-1,-1,100,80,-1,90,-1,-1,120,110,-1,-1,-1};
         Node root=construct(arr);
        display(root);
        System.out.println("size :"+size(root));
        System.out.println("height :"+height(root));
        maxmin(root);
          System.out.println("Max :"+max_);
            System.out.println("Min :"+min_);
          System.out.println("found element 20 :"+finddata(root,20));  
           System.out.println("found element 130 :"+finddata(root,130));  

           ArrayList<Node> ans=roottonodepath(root,120);
           Collections.reverse(ans);
           if(ans!=null){
             for(Node node:ans){
                 System.out.print(node.data+"  ");
             }
           }
           else
                 System.out.println("empty arraylist  ");

        
                 System.out.println();         

        ArrayList<Node> leaf=leafnodes(root);
        if(leaf!=null){
          for(Node node:leaf){
                 System.out.print(node.data+"  ");
             }  
        }
              System.out.println();    
              onlychild(root);
              System.out.println();  
              levelorder(root);
              System.out.println();  
              levelnodes(root);
              System.out.println();  
              snakenodes(root); 
              System.out.println();  
              System.out.println(commonanc(root,80,120)); 
              System.out.println();
              pair ob=checkbst(root);
              System.out.println("isbst :"+ob.isbst+"  no. of bst :"+ob.countbst);
              System.out.println();  
              System.out.println(checkinorder(root)); 
              System.out.println();  
              System.out.println(diameter(root)); 
              // System.out.println(); 
              // Node root2=nochild(root);
              // display(root2);
              // System.out.println(); 
              // Node root3=singlechild(root);
              // display(root3);
              // System.out.println(); 
              // Node root4=bothchild(root);
              // display(root4);
              System.out.println(); 
              int[] pre={10,20,40,50,60,30,70,90,80};
              int[] in={40,20,60,50,10,70,90,30,80};
              int[] post={40,60,50,20,90,70,80,30,10};
              Node root5=prein(pre,in,0,8,0,8);
              Node root6=postin(post,in,0,8,0,8);
            
              display(root5);
              System.out.println(); 
              display(root6);
                Node root7=prepost(pre,post,8,0,8);
              System.out.println(); 
              display(root7);
              




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

   static int max_=-10000;
   static int min_=10000;
   public static void maxmin(Node node){
       if(node==null)
        return;

       max_=Math.max(max_,node.data); 
       min_=Math.min(min_,node.data); 
       maxmin(node.left);
       maxmin(node.right);
   }

   public static Boolean finddata(Node node,int data){
       if(node==null)return false;
       return node.data==data || finddata(node.left,data) || finddata(node.right,data);
   }

   public static ArrayList<Node> roottonodepath(Node node,int data){
       if(node==null)return null;
       else if(node.data==data){
           ArrayList<Node> base=new ArrayList<>();
           base.add(node);
           return base;
       }

       ArrayList<Node> lans=roottonodepath(node.left,data);
       if(lans!=null){
           lans.add(node);
           return lans;
       }

        ArrayList<Node> rans=roottonodepath(node.right,data);
       if(rans!=null){
           rans.add(node);
           return rans;
       }

     return null;
   }

   //to print all the leaf nodes

   public static ArrayList<Node> leafnodes(Node node){
        if(node.left==null && node.right==null){
           ArrayList<Node> base=new ArrayList<>();
           base.add(node);
           return base;
       }
       if(node.left!=null){
       ArrayList<Node> ans=leafnodes(node.left);
       if(node.right!=null)
       ans.addAll(leafnodes(node.right));
       return ans;
       }
       else if(node.right!=null){
          ArrayList<Node> ans=leafnodes(node.right); 
          return ans;
       }

       return null;
   }

   //to print node with only on child

   public static void onlychild(Node node){
        
        if((node.left!=null && node.right==null) || (node.left==null && node.right!=null)){
           System.out.print(node.data+" , ");
           return;
       }
        
       if(node.left!=null)
         onlychild(node.left);
       if(node.right!=null)
         onlychild(node.right);
       return;
   }

   //to print the tree in levelorder
   public static void levelorder(Node node){
      LinkedList<Node> queue=new LinkedList<>();
      queue.addLast(node);
      
      while(queue.size()>0){
         Node n=queue.removeFirst();
         System.out.print(n.data+" ");

         if(n.left!=null)
          queue.addLast(n.left);
         if(n.right!=null)
          queue.addLast(n.right);
      }
   }

 //to print the node levelwise
  public static void levelnodes(Node node){
     LinkedList<Node> queue=new LinkedList<>();
      queue.addLast(node);
     LinkedList<Node> que2=new LinkedList<>();
      while(queue.size()>0){
        
         while(!queue.isEmpty()){

         Node n=queue.removeFirst();
         System.out.print(n.data+" ");

         if(n.left!=null)
          que2.addLast(n.left);
         if(n.right!=null)
          que2.addLast(n.right);
          }
          LinkedList<Node> temp=queue;
          queue=que2;
          que2=temp;
        System.out.println();
      } 
  }


  //to print the nodes in snake pattern
  public static void snakenodes(Node node){
     LinkedList<Node> queue=new LinkedList<>();
      queue.addLast(node);
      int level=0;
     LinkedList<Node> que2=new LinkedList<>();
      while(queue.size()>0){
        while(!queue.isEmpty()){

         Node n=queue.removeFirst();
         System.out.print(n.data+" ");

         if(level%2==0){
         if(n.left!=null)
          que2.addLast(n.left);
         if(n.right!=null)
          que2.addLast(n.right);
           }
         else{
         if(n.right!=null)
          que2.addLast(n.right);
         if(n.left!=null)
          que2.addLast(n.left);
          }

          }
           level++;
          LinkedList<Node> temp=queue;
          queue=que2;
          que2=temp;
          Collections.reverse(queue);
        System.out.println();
      }
  }


  //to print common ancestor of two nodes

  public static Boolean commonanc(Node node,int d1,int d2){
    if(node==null)return false;
    if(node.data==d1 || node.data==d2){
      return true;
    }

    Boolean left=commonanc(node.left,d1,d2);
    Boolean right=commonanc(node.right,d1,d2);
    if(left && right){
      System.out.println("common ancestor :"+node.data);
      return true;
    }

    return left||right;
  } 

  //to check it the tree if bst or not

  public static class pair{
    public int max_=Integer.MIN_VALUE;
    public int min_=Integer.MAX_VALUE;
    public int countbst=0;
    public Boolean isbst=true;
  }

  public static pair checkbst(Node node){
    if(node==null)
      return new pair();

    pair mypair=new pair();
    mypair.isbst=false;
    pair left=checkbst(node.left);
    pair right=checkbst(node.right);
     
    if(left.isbst && right.isbst &&left.max_<=node.data&&right.min_>=node.data){
         mypair.isbst=true;
         mypair.countbst=1;
       }

    mypair.max_=Math.max(node.data,Math.max(left.max_,right.max_));
    mypair.min_=Math.min(node.data,Math.min(left.min_,right.min_));
    mypair.countbst+=left.countbst+right.countbst;
    System.out.println(node.data+"  "+mypair.max_+"  "+mypair.countbst);

    return mypair;
  }

  //to check if the tree is bst or not using inorder traversal

  public static Boolean checkinorder(Node node){
    if(node.left==null || node.right==null)
     return true;
  
     if(checkinorder(node.left) && node.left.data<=node.data && 
        checkinorder(node.right)&& node.right.data>=node.data){
      return true;
    }
      
    return false;
  }

 //to print max diameter

  public static int diameter(Node node){
    if(node==null) 
     return 0;

    int lh=height(node.left);
    int rh=height(node.right);
    int ld=diameter(node.left);
    int rd=diameter(node.right);

    return Math.max(Math.max(ld,rd),lh+rh+1); 
  }

  // delete node with no child

  public static Node nochild(Node node){
    if(node==null)return null;
    if(node.left!=null || node.right!=null){
      node.left=nochild(node.left);
      node.right=nochild(node.right);
      return node;
    }
    else if(node.left==null && node.right==null){
      return null;
    }
    return node;
  }

  // delete node with single child

  public static Node singlechild(Node node){
    if(node==null)return null;
    if((node.left!=null && node.right==null) || (node.right!=null && node.left==null)){
      if(node.left!=null){
        node.data=node.left.data;
        node.left=null;
      }
       else if(node.right!=null){
         node.data=node.right.data;
         node.right=null;
       }
       return node;
    }

    node.left=singlechild(node.left);
    node.right=singlechild(node.right);
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

  public static Node bothchild(Node node){
    if(node==null)return null;
    if(node.left!=null && node.right!=null){
      int d=leftmax(node.left);
      node.data=d;
    }

    node.left=bothchild(node.left);
    node.right=bothchild(node.right);
    return node;
  }

  //contruct a tree using preorder and inorder

    public static Node prein(int[] pre,int[] in,int sp,int ep,int si,int ei){
      if(sp>ep || si>ei){
         return null;
      }
      
      int idx=si;
      Node node=new Node();
      while(idx<=ei){
        if(pre[sp]==in[idx])
         break;
         idx++;
      }
      node.data=pre[sp];
      int t=sp+(idx-si);
       node.left=prein(pre,in,sp+1,t,si,idx-1);
       node.right=prein(pre,in,t+1,ep,idx+1,ei);
         return node;
    }

  //contruct a tree using postorder and inorder

    public static Node postin(int[] post,int[] in,int sp,int ep,int si,int ei){
      if(sp>ep || si>ei){
         return null;
      }
      
      int idx=si;
      Node node=new Node();
      while(idx<=ei){
        if(post[ep]==in[idx])
         break;
         idx++;
      }
      node.data=post[ep];
      int t=sp+(idx-si);
       node.left=postin(post,in,sp,t-1,si,idx-1);
       node.right=postin(post,in,t,ep-1,idx+1,ei);
         return node;
    }

    //contruct a tree using preorder and postorder

    // public static Node prepost(int[] pre,int[] post,int sp,int ep,int si,int ei){
    //   if(sp>ep || si>ei){
    //      return null;
    //   }
    //  // System.out.println(si);
    //   int idx=si;
    //   Node node=new Node();
    //   // if(pre[sp]==post[ei])
    //    node.data=post[ei];
    //   while(idx<=ei){
    //     if(pre[sp+1]==post[idx])
    //      break;
    //      idx++;
    //   }
     
    //   int t=idx-si;
    //  System.out.println(pre[sp]+"  t:"+t+"  idx:"+idx+"  sp:"+sp+"  si:"+si);
    //    node.left=prepost(pre,post,sp+1,sp+1+t,si,si+t);
    //    node.right=prepost(pre,post,sp+t+2,ep,si+t+1,ei-1);
    //      return node;
    // }


  static int preindex=0;  
public static Node prepost(int[] pre,int[] post,int size,int postl,int posth){
    if(preindex>size || postl>posth)
      return null;

     Node node=new Node();
     node.data=pre[preindex];
     preindex++;
    
    if(postl==posth)
     return node;

    int idx;
    for(idx=0;idx<=posth;idx++){
        if(pre[preindex]==post[idx])
         break;  
    }

     if(idx<=posth){
    node.left=prepost(pre,post,size,postl,idx);
    node.right=prepost(pre,post,size,idx+1,posth-1);
     }

    return node;
}

  
}