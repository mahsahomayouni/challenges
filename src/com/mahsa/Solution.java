package com.mahsa;

import com.sun.deploy.security.SelectableSecurityManager;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Map.Entry.comparingByKey;

public class Solution {

    public Integer min;
    public Integer max;

        public int solutionOne(int[] A) {
            //int[] A = {1, 23, 4, 55};
            int sum = 0;
            for (int i=0;i<A.length;i++) {
                if (Math.abs(A[i]) > 9 && Math.abs(A[i]) < 100) {
                    sum += A[i];
                }
            }

            return sum;
        }

    public String solutionTwo(String[] A, String[] B, String P) {
        Map<String,String> contacts=new HashMap<>();
        for(int i=0;i<A.length;i++){
            contacts.put(A[i],B[i]);
        }

        Map<String, String> sortedContacts = contacts.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));


        Optional<String> result= sortedContacts
                .entrySet()
                .stream()
                .filter(
                        entry -> entry.getValue().contains(P))
                .map(Map.Entry::getKey).findFirst();

    if (result.isPresent())
        return result.get();

        return "NO CONTACT";

    }

    public int[] solutionThree_1(int[] A, int F, int M) {
        int[] result = new int[F];

        int sum = IntStream.of(A).sum();
        int x=6*M-sum;
        if (x<1)
            return new int[0];
        else
            if (x/F>6)
                return new int[0];

        List<Integer> temp=new ArrayList<>();
        Integer tempsum=0;
        Map<List<Integer>,Integer> mymap=new HashMap<>();
        List<String> myPosibility=new ArrayList<>();
        List<Integer> posibility= new ArrayList<Integer>( Arrays.asList(0,1,2,3,4,5,6));
        String p = "";
        for (int i=1; i<=6;i++){

            for (int j=1; j<=6;j++) {

                for (int k = 1; k <= F; k++) {
                    p += i;


                }
                if (sumOfArray(p) == x) {
                    myPosibility.add(p);
                }
                p="";

            }

//               temp.add(posibility.get(i));
//                temp.add(posibility.get(j));
//                tempsum=posibility.get(i)+posibility.get(j);
                //if tempsum=


//            if (tempsum==x)
//            mymap.put(temp,tempsum);
        }
        // write your code in Java SE 8
        return null;
    }

    private int sumOfArray(String p){
            int sum=0;
            for (int i=0;i<p.length();i++){
                sum+=Character.getNumericValue(p.charAt(i));
            }
            return sum;
    }


    public int solutionThree_2(int n){
        Boolean flag=false;
        String binary=Integer.toBinaryString(n);
        int len=binary.length();
        if (len>2) {

            if (binary.charAt(0)=='1') {
                if (binary.endsWith("1")) flag=true;
                for (int i = 0; i < binary.length() - 2; i++) {
                    String temp = makeTemp(binary.length() - 1 - i);
                    if (binary.contains(temp)) {
                        if (flag || binary.indexOf(temp)+temp.length()<len)
                        return binary.length() - 2 - i;
                    }
                }
            }
            else
                return 0;
        }
        else return 0;
        return 0;
    }

    private String makeTemp(int n){
        String t="";
        for (int i = 0; i < n; i++) {
            t+="0";
        }
        return t;
    }

    public int firstnumbernotcontain(int[] a){

        List<Integer> list = IntStream.of(a).boxed().collect(Collectors.toCollection(ArrayList::new));

        int min = Collections.min(list);
        int max=Collections.max(list);
        Collections.sort(list);
        Integer result=0;
        for (Integer i=max-1;i>0;i--){
            if (!list.contains(i)){
                result=i;
                break;
            }
        }
       // list.contains()
        if (result==0){
            result=max+1;
        }

       return result.intValue();
    }
    public int firstpositivenumbernotcontain(int[] a){

        List<Integer> list = IntStream.of(a).boxed().filter(i-> i>0).collect(Collectors.toCollection(ArrayList::new));


        if (list.size()==0)
            return 1;

        Collections.sort(list);
        int min = Collections.min(list);
        int max=Collections.max(list);
        Integer result=0;
        for (Integer i=max-1;i>0;i--){
            if (!list.contains(i)){
                result=i;
                break;
            }
        }

        if (result==0){
            result=max+1;
        }

        return result.intValue();
    }



    //public  List<Integer> solutionDice(int[] A, int F, int M) {
    public  int[]solutionDice(int[] A, int F, int M) {
       // int[] result = new int[F];
        List<Integer> result=new ArrayList<>();
        int sum = IntStream.of(A).sum();
        int x = 6 * M - sum;
        if (x < 1)
            //return result;
            return new int[]{};
        else if (x / F > 6)
           // return result;
            return new int[]{};

        int min=0;
        int max=0;
        switch (F){
            case 1: min=1;max=6; break;
            case 2: min=11;max=66; break;
            case 3: min=111;max=666; break;
            case 4: min=1111;max=6666; break;
            case 5: min=111111;max=66666; break;
            case 6: min=111111;max=666666; break;
        }

        List<Integer> possibilities = new ArrayList<>();
        //List<Integer> filteredPossibilities = new ArrayList<>();
        for (int i = min; i <= max; i++) {

            //////////////////////
            if (!(Integer.valueOf(i).toString().contains("0"))||
                    (Integer.valueOf(i).toString().contains("7"))||
                            (Integer.valueOf(i).toString().contains("8"))||
                                    (Integer.valueOf(i).toString().contains("9"))){
                if (sumOfPossibilities(i)==x){
                    possibilities.add(i);
                }

            }
            //////////////////////
//            possibilities.add(i);
        }

//        Iterator<Integer> iterator = possibilities.iterator();
//        while(iterator.hasNext()) {
//            String item=iterator.next().toString();
//                if (item.contains("0") ||
//                        item.contains("7") ||
//                        item.contains("8") ||
//                        item.contains("9"))
//                    iterator.remove();
//        }
//        possibilities.forEach(item->{
//            if (sumOfPossibilities(item)!=x)
//                possibilities.remove(item);
//        });
        ////////////////////////////////////////////////////////////////////////////// new
        int[] resultArray = possibilities.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        if (resultArray.length>0)
            return resultArray;
        else
            return new int[]{};
        //////////////////////////////////////////////////////////////////////////////new

//        if(possibilities.size()>0)
//        {
////////            String strResult = possibilities.get(0).toString();
////////            for (int i = 0; i < strResult.length(); i++) {
////////                result[i] = strResult.charAt(possibilities.get(i)) ;
////////            }
//            return possibilities;
//        }
//        else
//            return result;

    }

    private int sumOfPossibilities(Integer p){
        int sum=0;
        String str=p.toString();
        for (int i=0;i<str.length();i++){
            sum+=Character.getNumericValue(str.charAt(i));
        }
        return sum;
    }

    //یک آرایه میگیرد. اندیس عضو هایی که جمع آنها با target برابر است، برمیگرداند
        public int[] twoSum(int[] nums, int target) {

            int[] result = new int[2];
            for (int i = 0; i <= nums.length - 2; i++) {
                for (int j = i+1; j <= nums.length - 1; j++) {
                    if (nums[i] + nums[j] == target) {
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                }
            }
            return result;
        }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(!(nums.length >3000))
        for (int i = 0; i <= nums.length - 3; i++) {
            for (int j = i + 1; j <= nums.length - 2; j++) {
                for (int k = j+1; k <= nums.length - 1; k++) {
                    if ((nums[i] + nums[j] + nums[k] == 0) && (i !=j) &&(i!=k) && (j!=k))  {
                        List<Integer> item = new ArrayList<>();
                        item.add(nums[i]);
                        item.add(nums[j]);
                        item.add(nums[k]);
                        Collections.sort(item);
                        if(!result.contains(item))
                            result.add(item);
                    }
                }
            }
        }
        return result;
    }

    public boolean isPalindrome(int x) {
            Integer in=x;
            if (in<0)
                return false;
            String s=in.toString();
            String reverse="";
            for(int i=s.length()-1;i>=0;i--){
                reverse+=s.charAt(i);
            }
            if (s.equals(reverse))
                return true;
        return false;
    }
    public int maxDepth(TreeNode root) {

        if(root==null) return 0;

        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));

    }

//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result=new ArrayList<>();
//        if(root==null)
//            return result;
//
//        //if (root.left!=null)
//         inorderTraversal(root.left);
//        result.add (root.val);
//        System.out.println(root.val);
//        //else if (root.right!=null)
//             inorderTraversal(root.right);
//        return result;
//
//    }


        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            helper(root, res);
            return res;
        }

        public void helper(TreeNode root, List<Integer> res) {
            if (root != null) {
                helper(root.left, res);
                res.add(root.val);
                helper(root.right, res);
            }
        }


     public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

  }

    public boolean hasCycle(ListNode head) {
            List<ListNode> existNodes=new ArrayList<>();
         if (head==null ) {
             return false;
         }
         while(head!=null){
            if (existNodes.contains(head))
                return true;
            else
                existNodes.add(head);
            head=head.next;
         }
         return false;

    }

     // Definition for singly-linked list.
     static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
             next = null;
          }
      }

    public static class ListNodeForAddTwoNumbers {
      int val;
        ListNodeForAddTwoNumbers next;
        ListNodeForAddTwoNumbers() {}
        ListNodeForAddTwoNumbers(int val) { this.val = val; }
        ListNodeForAddTwoNumbers(int val, ListNodeForAddTwoNumbers next) { this.val = val; this.next = next; }
  }

    public ListNodeForAddTwoNumbers addTwoNumbers(ListNodeForAddTwoNumbers l1, ListNodeForAddTwoNumbers l2) {
            List<String> numList1=new ArrayList<>();
        List<String> numList2=new ArrayList<>();
        String num1="";
        String num2="";
        String sum="";

           while (l1!=null){

               numList1.add(Integer.toString(l1.val));
               l1=l1.next;
           }
        while (l2!=null){
            numList2.add(Integer.toString(l2.val));
            l2=l2.next;
        }
        Collections.reverse(numList1);
        Collections.reverse(numList2);
        for(int i=0;i<numList1.size();i++){
            num1+=numList1.get(i);
        }
        for(int i=0;i<numList2.size();i++){
            num2+=numList2.get(i);
        }
        sum=Integer.toString(Integer.parseInt(num1)+Integer.parseInt(num2));
        ListNodeForAddTwoNumbers head=new ListNodeForAddTwoNumbers(0);
//        ListNodeForAddTwoNumbers result=new ListNodeForAddTwoNumbers(0);
        ListNodeForAddTwoNumbers result=head;

         for (int i=sum.length()-1;i>0;i--){
             Integer r=Integer.parseInt(String.valueOf(sum.charAt(i)));
             ListNodeForAddTwoNumbers node=new ListNodeForAddTwoNumbers(r);
             result.next=node;
             result=result.next;

         }
//         int i=sum.length()-1;
//         while (head!=null){
//             Integer r=Integer.parseInt(String.valueOf(sum.charAt(i)));
//
//             ListNodeForAddTwoNumbers node=new ListNodeForAddTwoNumbers(r);
//             i--;
//             if (i>=0)
//                result.next=node;
//             else
//                 result.next=null;
//             result=result.next;
//         }

        return result.next;

    }
    public ListNodeForAddTwoNumbers addTwoNumbersNew(ListNodeForAddTwoNumbers l1, ListNodeForAddTwoNumbers l2) {
        ListNodeForAddTwoNumbers dummyHead = new ListNodeForAddTwoNumbers(0);
        ListNodeForAddTwoNumbers p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNodeForAddTwoNumbers(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNodeForAddTwoNumbers(carry);
        }
        return dummyHead.next;
    }

//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//            ListNode merge=new ListNode();
//            while(list1.next!=null ){
//                merge.next=new ListNode(n);
//            }
//
////        list1.addAll(list2);
////        Collections.sort(list1);
////        return list1.getFirst();
//
//    }
//
//    public class ListNode {
//      int val;
//     ListNode next;
//      ListNode() {}
//      ListNode(int val) { this.val = val; }
//      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//    }

    public int ssss(int[] A) {
        // write your code in Java SE 8

        if (A.length==0)
            return 1;
        List<Integer> list = new ArrayList<Integer>(A.length);
        for (int i : A)
        {
            list.add(i);
        }


        list.stream().filter(i->i>0).sorted();

        for (int i=0;i<list.size();i++){
            if (!list.contains(i))
           //if (A[i]!=i )
                return i;
        }
        return list.get(list.size())+1;
    }
    public int sss(String S) {
        if (!S.matches("^[0-1]*$") || S.equals(""))
            return 0;
//            StringBuilder s = new StringBuilder();
//            for (int i=0;i<400000;i++)
//                s.append("1");
//            S= String.valueOf(s);

        int decimalnumber = 0;
        int power = 0;
        for (int i=S.length()-1;i>=0;i--)
        {
                int temp = Integer.parseInt(String.valueOf(S.charAt(i)));
                decimalnumber += temp*Math.pow(2, power);
                power++;

        }
        Integer V=decimalnumber;
        int count=0;
         while (V!=0){
             if (V%2==0) {
                 V = V / 2;
             }
             else
                 V-=1;
             count++;
         }
        return count;
    }

    public int minimumCuttedtree(int[] A)
    {
        boolean expected = true;
        int a = 0;
        int b = 0;
        int result=0;

        for (int i = 1; i < A.length; i++)
        {
            if ((A[i] > A[i - 1]) == expected)
                a++;
            else
                b++;

            expected = !(expected);
        }
        if (a > b)
            result=A.length - 1 - a;
        else
            result=A.length - 1 - b;
        return result;

       // return res > res1 ? A.length - 1 - res : A.length - 1 - res1;
    }

}
