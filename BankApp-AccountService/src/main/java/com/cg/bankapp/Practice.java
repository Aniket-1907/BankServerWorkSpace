package com.cg.bankapp;

import org.springframework.boot.SpringApplication;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.util.stream.Collectors;

public class Practice {
    public static void main(String[] args) {
        String s1="Aniket";
        String s2="Aniket";
        String s3=new String("Aniket");
        String s4=new String("Aniket");
        System.out.println( s1 == s2 );
        System.out.println( s3 == s4 );
        System.out.println( s1 == s3 );
        s2="Rahul";
        System.out.println();
        System.out.println();

        long t1=System.currentTimeMillis();
        System.out.println(searchMatrix(new int[][]{
                {1,3,5,7},{10,11,16,20},{23,30,34,60}
        },13));
        System.out.println(searchMatrix(new int[][]{
                {1,3,5,7},{10,11,16,20},{23,30,34,60}
        },3));
        System.out.println(searchMatrix(new int[][]{
                {1,3,5,7},{10,11,16,20},{23,30,34,60}
        },34));

        long t2=System.currentTimeMillis();
        System.out.println("Time taken for searchMatrix: "+(t2-t1)+" ms");
        long t3=System.currentTimeMillis();
        System.out.println(searchMatrixStream(new int[][]{
                {1,3,5,7},{10,11,16,20},{23,30,34,60}
        },13));
        System.out.println(searchMatrixStream(new int[][]{
                {1,3,5,7},{10,11,16,20},{23,30,34,60}
        },3));
        System.out.println(searchMatrixStream(new int[][]{
                {1,3,5,7},{10,11,16,20},{23,30,34,60}
        },34));
        long t4=System.currentTimeMillis();
        System.out.println("Time taken for searchMatrixStream: "+(t4-t3)+" ms");
        List<List<String>> res=groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        System.out.println("Group Anagrams Result: "+res);
        topKFrequent(new int[]{1,1,1,2,2,3},2);
        isValidSudoku(new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        });
        System.out.println(reversePairs(new int[]{1,3,2,3,1}));
        System.out.println(reversePairs(new int[]{2,4,3,5,1}));
        int  a=363;
        System.out.println(a>>1);
        System.out.println(a>>2);
        System.out.println(a>>3);
        System.out.println(longestSubarray(new int[]{10, 5, 2, 7, 1, 9},15));
        System.out.println(longestSubarray(new int[]{-3, 2, 1},6));

        Calculator c = (x, b) -> x + b;

        HttpClient httpClient=HttpClient.newHttpClient();
        HttpRequest httpRequest=HttpRequest.newBuilder().uri(java.net.URI.create("https://www.aniketagg.in")).build();
        HttpResponse<String> httpResponse=null;
        try {
            httpResponse=httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(httpResponse!=null) {
            System.out.println(httpResponse.body());
        }

        Student stu= new Student("Aniket", 25);
        System.out.println(stu.name());


        SingletonClass sc1=SingletonClass.getInstance();
        SingletonClass sc2=SingletonClass.getInstance();
        SingletonClass sc3=SingletonClass.getInstance(10);
        SingletonClass sc4=SingletonClass.getInstance(20);
        System.out.println("Are Equal - "+sc1.equals(sc2));
        System.out.println("Values - "+sc1.getValue()+" "+sc2.getValue()+" "+sc3.getValue()+" "+sc4.getValue());
        rearrangeArray(new int[]{3,1,3,2,1,3});

        System.out.println("Active threads: " + Thread.activeCount());
        Thread.getAllStackTraces()
                .keySet()
                .forEach(thread -> System.out.println(thread.getName() + " - " + thread.getState())
                );

//        scoreOfParentheses("((()())(()))");

//        isPalindromic("leet");

        int d1=nearestDrone(new int[][]{{0,0,8},{2,2,9}}, new int[]{3,4});
        int d2=nearestDrone(new int[][]{{2,1,5},{4,4,5},{6,6,8}}, new int[]{5,5});
        int d3=nearestDrone(new int[][]{{4,4,5}}, new int[]{8,6});
        System.out.println(String.format("Nearest Drone for Target 1: %d, Nearest Drone for Target 2: %d, Nearest Drone for Target 3: %d", d1,d2,d3));

        maxProduct(31);
        maxProduct(22);
        maxProduct(124);

    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String s:strs){
            boolean f=true;
            for(Map.Entry<String,List<String>> e:map.entrySet()){
                if(isAnagram(s,e.getKey())){
                    f=false;
                    map.get(e.getKey()).add(s);
                    break;
                }
            }
            if(f)
                map.put(s,new ArrayList<>(List.of(s)));
        }
        return new ArrayList<>(map.values());

    }
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;

        int[] map=new int[26];
        for(int i=0;i<s.length();i++){
            map[s.charAt(i) - 'a']++;
            map[t.charAt(i) - 'a']--;
        }
        for(int n:map){
            if(n!=0) return false;
        }
        return true;
    }
    public static int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->b[1]-a[1]);
        Map<Integer,Integer> map=new HashMap<>();
        for(int n:nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            pq.add(new int[]{e.getKey(),e.getValue()});
        }
        int[] res=new int[k];
        int i=0;
        while(k-->0){
            res[i++]=pq.poll()[0];
        }
        return res;
    }
    public static boolean isValidSudoku(char[][] board) {
        int n=9;
        for(int i=0;i<n;i++){
            Set<Character> row=new HashSet<>();
            Set<Character> col=new HashSet<>();
            for(int j=0;j<n;j++){
                if(board[i][j] != '.'){
                    int sz=row.size();
                    row.add(board[i][j]);
                    if(sz==row.size()) return false;
                }
                if(board[j][i] != '.'){
                    int sz=col.size();
                    col.add(board[j][i]);
                    if(sz==col.size()) return false;
                }
            }
        }

        return true;
    }
    public static int reversePairs(int[] nums) {
        int sz=nums.length;
        List<int[]> l=new ArrayList<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<sz;i++){
            int[] n=new int[]{nums[i],i,nums[i]*2};
            pq.add(n);
        }
        while(!pq.isEmpty()){
            l.add(pq.poll());
        }
        int res=0;
        for(int i=sz-1;i>=0;i--){
            int[] n=l.get(i);
            int j=0;
            while(j<sz && n[0] > l.get(j)[2]){
                if(n[1] < l.get(j)[1]){
                    res++;
                }
                j++;
            }
        }
        return res;
    }
    public static int longestSubarray(int[] nums, int k) {
        int max=0;
        Map<Integer,Integer> map=new HashMap<>();
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            map.putIfAbsent(sum,i);
            if(sum==k){
                max=Math.max(max,i+1);
            }
            if(map.containsKey(sum-k)){
                max=Math.max(max,i-map.get(sum-k));
            }
        }
        return max;
    }
    public boolean isPalindrome(String s) {
        List<Character> li=s.chars().mapToObj(c -> (char)c).filter(Character::isLetterOrDigit).map(Character::toLowerCase).toList();
//        Arrays.stream(s.toCharArray()).filter(c -> (c > 'a' && c < 'z') || (c > 'A' && c < 'Z')).collect(Collectors.toList());
        System.out.println(li);
        return true;
    }
    public static int[] rearrangeArray(int[] nums) {
        int[] ans=new int[nums.length];
        Map<Integer,Integer> map=new TreeMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        int i=0;
        while(!map.isEmpty()){
            for(int n:map.keySet()){
                ans[i++]=n;
            }
            map.replaceAll((k,v) -> v-1);
            map.entrySet().removeIf( e -> e.getValue()==0);
        }
        return ans;
    }
    public static boolean isPalindromic(String s) {
        String str=s.chars().mapToObj(c -> (char)c).map(c -> (int)c).map(Integer::toBinaryString).map( st -> String.format("%8s",st).replace(' ','0')).collect(Collectors.joining());
        System.out.println(str);
        return str.contentEquals(new StringBuilder(str).reverse());

    }
    public static int nearestDrone(int[][] drones, int[] target) {
        int[][] distance=new int[drones.length][5];
        int i=0;
        for(int[] drone:drones){
            int x=Math.abs(target[0]-drone[0]);
            int y=Math.abs(target[1]-drone[1]);
            int d=x+y;

            distance[i][0]= d<drone[2] ? d: -1;
            distance[i][1]=drone[0];
            distance[i][2]=drone[1];
            distance[i][3]=drone[2];
            distance[i][4]=i;
            i++;
        }
        Arrays.sort(distance,Comparator.comparing(a -> a[0]));
        int sd=Integer.MAX_VALUE;
        int ind=drones.length;
        boolean flag=false;
        for(int[] d:distance){
            if(d[0]== -1) continue;
            sd=Math.min(sd,d[0]);
            if(d[0]==sd){
                ind=Math.min(ind,d[4]);
                flag=true;
            }
            else break;
        }
        if(flag) return ind;
        else return -1;
    }
    public static int maxProduct(int n) {
        int[] d=new int[10];
        while(n>0){
            int di=n%10;
            d[di]++;
            n/=10;
        }
        int max=-1;
        int secondMax=-1;
        for(int i=9;i>=0;i--){
            if(d[i]>0) {
                max=i;
                d[i]--;
                break;
            }
        }
        for(int i=9;i>=0;i--){
            if(d[i]>0) {
                secondMax=i;
                d[i]--;
                break;
            }
        }
        return max*secondMax;

    }
    public static int scoreOfParentheses(String s) throws EmptyStackException{
        int score=0;
        Stack<Character> st=new Stack<>();
        while(!s.isEmpty()){
            st=new Stack<>();
            for(char c:s.toCharArray()){
                if( c == '(' ){
                    st.push(c);
                }
                else if( c == ')' ){
                    if(st.peek() == '(' ){
                        st.pop();
                        if(!st.isEmpty() && Character.isDigit(st.peek())){
                            int n=st.pop()-'0';
                            n++;
                            st.push(Character.valueOf((char) (n + '0')));
                        }
                        else st.push('1');
                    }
                    else st.push(c);
                }
                else if(Character.isDigit(c)){
                    if(Character.isDigit(st.peek())){
                        int n=st.pop()-'0';
                        n++;
                        st.push(Character.valueOf((char) (n + '0')));
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            st.forEach(sb::append); // Shorthand for-each loop

            s = sb.toString();
            System.out.println(st);

        }

        return score;
    }
    public static boolean searchMatrix(int[][] matrix, int k) {
        int m=matrix.length;
        int n=matrix[0].length;

        int t=0;
        int b=m-1;
        while(t<b){
            int mr=(t+b)/2;
            if( matrix[mr][0] < k && matrix[mr][n-1] > k) break;
            else if( matrix[mr][0] > k ) b=mr-1;
            else t=mr+1;
        }
        t = (t + b) / 2;
        System.out.println("t = "+t);
        int l=0;
        int r=n-1;
        while(l<r){
            int mr=(l+r)/2;
            if( matrix[t][mr] < k ) l=mr+1;
            else if( matrix[t][mr] > k ) r=mr-1;
            else return true;
        }
        return false;
    }
    public static boolean searchMatrixStream(int[][] matrix, int k) {
        return Arrays.stream(matrix)
                .flatMapToInt(Arrays::stream)
                .anyMatch(num -> num == k);
    }

}
