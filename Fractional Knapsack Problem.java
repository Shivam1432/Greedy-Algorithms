import java.util.*;
class Result
{
  static double fractionalKnapsack(int val[], int weight[], int n, int capacity)
  {
    Item item[]=new Item[n];
    for(int i=0;i<n;i++)
    {
      item[i]=new Item(weight[i],val[i],i);
    }
    Arrays.sort(item,new Comparator<Item>(){
      @Override
      public int compare(Item o1,Item o2)
      {
        return o2.cost.compareTo(o1.cost);
      }
    });
    double count=0;
    for(Item i:item)
    {
      int wt=(int)i.wt;
      int value=(int)i.v;
      if(capacity-wt>=0)
      {
        capacity-=wt;
        count+=(double)value;
      }
      else
      {
        double fraction=((double)capacity/(double)wt);
        capacity=(int)(capacity-(fraction*wt));
        count+=(double)(fraction*value);
        break;
      }
    }
    return count;
  }
  
}
class Item{
  Double cost;
  int wt,v,i;
  Item(int w,int v,int i)
  {
    wt=w;
    this.v=v;
    this.i=i;
    cost=new Double((double)v/(double)w);
  }
}
