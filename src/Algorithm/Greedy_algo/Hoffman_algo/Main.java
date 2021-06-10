package Algorithm.Greedy_algo.Hoffman_algo;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        String s = "aaaabbbbcc";
        Hoffman_algo hf = new Hoffman_algo(s);
        System.out.println(hf.getEncodeString());
    }
}

class Node implements Comparable<Node>{
    private char data;
    private int frequency;
    private Node left;
    private Node right;

    public Node(char data) {
        this.data = data;
        this.frequency = 0;
        this.left = null;
        this.right = null;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public int compareTo(Node o) {
        return this.frequency - o.frequency;
    }

    @Override
    public String toString() {
        return this.data + " frequency = " + this.frequency + " ";
    }
}

class Hoffman_algo{
    private String s;
    private HashMap<Character, Integer> frequency_table = new HashMap<>();
    private HashMap<Character, String> encode_table = new HashMap<>();
    private Node root;

    public Hoffman_algo(String s) {
        this.s = s;
        make_frequency_table(s);
        this.root = make_tree();
        buildEncodeTable(this.root, "");
        System.out.println(encode_table);
    }

    private void make_frequency_table(String s){
        for (int i = 0; i < s.length(); i++){
            char k = s.charAt(i);
            if (frequency_table.containsKey(k)){
                frequency_table.put(k, frequency_table.get(k) + 1);
            }else{
                frequency_table.put(k, 1);
            }
        }
        System.out.println(frequency_table);
    }

    private PriorityQueue<Node> make_heap(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> k : frequency_table.entrySet()){
            Node n = new Node(k.getKey());
            n.setFrequency(k.getValue());
            pq.add(n);
        }
        return pq;
    }

    private Node make_tree(){
        PriorityQueue<Node> heap = make_heap();
        Node temp = null;
        while (heap != null){
            temp = new Node(Character.MIN_VALUE);
            Node n1 = heap.poll();
            temp.setLeft(n1);
            temp.setFrequency(temp.getFrequency() + n1.getFrequency());

            Node n2 = heap.poll();
            if (n2 != null){
                temp.setRight(n2);
                temp.setFrequency(temp.getFrequency() + n2.getFrequency());
            }else
                break;
            heap.add(temp);
        }
        return temp;
    }

    private void buildEncodeTable(Node root, String encode_str){
        if (root == null)
            return;
        if (root.getData() != Character.MIN_VALUE){
            this.encode_table.put(root.getData(), encode_str);
        }

        buildEncodeTable(root.getLeft(), encode_str + '0');
        buildEncodeTable(root.getRight(), encode_str + '1');
    }

    public String getEncodeString(){
        String encode = "";
        for (char c: this.s.toCharArray()){
            encode += this.encode_table.get(c);
        }
        return encode;
    }
}
