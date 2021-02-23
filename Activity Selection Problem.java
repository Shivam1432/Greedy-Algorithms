class Result {
  static void activitySelection(int[] start, int[] finish) {
	int i=0,j,k,count=1;
    int n=finish.length;
    System.out.print(start[i]+" ");
    for(j=1;j<n;j++)
    {
      if(start[j]>=finish[i])
      {
        i=j;
        System.out.print(start[i]+" ");  
      }
    }
  }
}
