class Result {
  static int intervalScheduling(int[] start, int[] end) {
	int n=start.length;
    Interval in[]=new Interval[n];
    for(int i=0;i<n;i++)
    {
      in[i]=new Interval(i,start[i],end[i]);
    }
    Arrays.sort(in,new Comparator<Interval>(){
      @Override
      public int compare(Interval i1,Interval i2)
      {
        if(i1.e!=i2.e)
        {
          return i1.e-i2.e;
        }
        else
        {
          if(i1.s!=i2.s)
          {
            return i1.s-i2.s;
          }
          else
          {
            return i1.id-i2.id;
          }
        }
      }
    });
    int i=0,j,count=1;
	for(j=1;j<n;j++)
    {
      if(in[j].s>=in[i].e)
      {
        i=j;
        count++;
      }
    }
    return count;
  }
}
class Interval{
  int id,s,e;
  Interval(int i,int s,int e)
  {
    this.id=i;
    this.s=s;
    this.e=e;
  }
}
