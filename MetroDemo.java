import java.util.Arrays;
    import java.util.PriorityQueue;
    import java.util.ArrayList;
    import java.util.AbstractCollection;
    import java.util.Comparator;
     import java.util.Scanner;
     
    public class MetroDemo {
	static Scanner in=new Scanner(System.in);
        public static void main(String[] args)  {
            
            Metro solver = new Metro();
            
            solver.solve(1);
        }
     
        static class Metro {
            public void solve(int testNumber) {
                int n = in.nextInt();
                int m = in.nextInt();
                ArrayList<pair> arrayList[] = new ArrayList[n + 1];
                for (int i = 0; i <= n; i++) arrayList[i] = new ArrayList();
     
     
                for (int i = 0; i < m; i++) {
                    int s = in.nextInt();
                    long t = in.nextLong();
                    int arr[] = new int[s];
                    for (int j = 0; j < s; j++) arr[j] = in.nextInt();
                    for (int j = 0; j < s - 1; j++) {
                        int we = in.nextInt();
                        arrayList[arr[j]].add(new pair(arr[j + 1], we, t));
                        t += we;
                    }
                }
               int st = in.nextInt();
               int end = in.nextInt();
                long dis[] = new long[n + 1];
                Arrays.fill(dis, Long.MAX_VALUE / 2);
                dis[st] = 0;
                PriorityQueue<pair2> pq= new PriorityQueue<>(new Comparator<pair2>() {
     
                    public int compare(pair2 o1, pair2 o2) {
                        return Long.compare(o1.dis, o2.dis);
                    }
                });
     
                pq.add(new pair2(st, dis[st]));
                boolean visited[] = new boolean[n + 1];
                visited[st] = true;
     
                 while (!pq.isEmpty()) {
                    pair2 p = pq.poll();
                    if (p.node == end) {
                        System.out.println(dis[p.node]);
                        return;
                    }
     
                    for (pair pp : arrayList[p.node]) {
                        if (dis[p.node] <= pp.c && dis[pp.a] > dis[p.node] + pp.b) {
                            dis[pp.a] = dis[p.node] + pp.b;
                            pq.add(new pair2(pp.a, dis[pp.a]));
                        }
                    }
     
                }
                System.out.println(-1);
       }
            class pair2 {
                int node;
                long dis;
     
                public pair2(int node, long dis) {
                    this.node = node;
                    this.dis = dis;
                }
            }
            class pair {
                int a;
                long b,c;
                    public pair(int a, long b, long c) {
                    this.a = a;
                    this.b = b;
                    this.c = c;
                }
            }
        }    
    }