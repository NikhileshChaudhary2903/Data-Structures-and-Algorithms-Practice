public class JobHelp {



    public static void printStrings(int n,int k) {

        List<List<Integer>> list = new ArrayList<>();
        dfs(list,n,new ArrayList<>(),k);

        System.out.println(list);
        System.out.println(list.size());

    }

    public static void dfs(List<List<Integer>> list,int n, List<Integer> inner,int k) {

        if(inner.size() == n) {
            list.add(new ArrayList<>(inner));
            return;
        }

        for(int i = 0; i < k;i++) {
            inner.add(i);
            dfs(list,n, inner,k);
            inner.remove(inner.size() - 1);
        }
    }
