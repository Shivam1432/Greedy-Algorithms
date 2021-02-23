import java.util.*;
class Result {
  static int jobScheduling(int[] deadlines, int[] profits) {
    int n=profits.length;
    Job j[]=new Job[n];
    for(int i=0;i<n;i++)
    {
      j[i]=new Job(i,deadlines[i],profits[i]);
    }
    Arrays.sort(j,new Comparator<Job>(){
      @Override
      public int compare(Job j1,Job j2){
        if (j1.p != j2.p) 
                return j2.p - j1.p; 
            else
                return j2.d - j1.d;
      }
    });
    int profit=0;
    TreeSet<Integer> ts = new TreeSet<>(); 
        for (int i = 0; i < n; i++) 
            ts.add(i); 
        for (int i = 0; i < n; i++) { 
            Integer x = ts.floor(j[i].d - 1); 
  
            if (x != null) { 
                profit+=j[i].p; 
                ts.remove(x); 
            } 
        } 
    return profit;
  }
}
class Job{
  int i,p,d;
  Job(int i,int d,int p)
  {
    this.i=i;
    this.p=p;
    this.d=d;
  }
}
