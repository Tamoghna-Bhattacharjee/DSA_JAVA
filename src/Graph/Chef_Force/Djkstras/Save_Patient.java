package Graph.Chef_Force.Djkstras;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

class Save_Patient
{
    public static void main (String[] args) throws java.lang.Exception
    {
        scan.init(System.in);
        //Scanner scanner = new Scanner(System.in);
        int N = scan.nextInt(), M = scan.nextInt(), R = scan.nextInt();
        int x = scan.nextInt(), y = scan.nextInt();

        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        ArrayList<Node>[] arr = new ArrayList[N+1];
        for(int i = 0; i<arr.length; i++){
            arr[i] = new ArrayList<Node>();
        }

        while (R-- > 0){
            int u = scan.nextInt();
            int v = scan.nextInt();
            int w = scan.nextInt();
            arr[u].add(new Node(v, w));
            arr[v].add(new Node(u, w));
        }

        // dijkstra
        Set<Integer> visit = new HashSet<>();
        Comparator<Node> cmp = new Comparator<Node>() {
            @Override
            public int compare(Node t1, Node t2) {
                return t1.w - t2.w;
            }
        };
        PriorityQueue<Node> pq = new PriorityQueue<>(cmp);
        dist[x] = 0;
        pq.add(new Node(x, dist[x]));
        while(!pq.isEmpty()){
            Node curr = pq.poll();
            int u = curr.v;
            if (!visit.contains(u)){
                visit.add(u);
                for(Node child : arr[u]){
                    dist[child.v] = Math.min(dist[child.v], dist[u]+child.w);
                    pq.add(new Node(child.v, dist[child.v]));
                }
            }
        }
        // dijkstra
        if(dist[y] > M)System.out.print("died");
        else System.out.print("alive " + dist[y]);
    }

    static class Node {
        int v;
        int w;
        public Node(int v, int w){
            this.v = v;
            this.w = w;
        }
    }
}

class scan {
    static BufferedReader reader;
    static StringTokenizer tokenizer;
    static void init(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input));
        tokenizer = new StringTokenizer("");
    }
    static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }
    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}